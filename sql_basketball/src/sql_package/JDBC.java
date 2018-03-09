package sql_package;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import oracle.sql.ARRAY;
import oracle.sql.Datum;
import oracle.sql.STRUCT;

public class JDBC {
	private final static String SQL_DRIVER_NAME = "oracle.jdbc.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@oraclenba.c9jdzgmhpebu.eu-west-1.rds.amazonaws.com:1521:orcl";

	private Connection connection = null;
	private Statement statement = null;

	/**
	 * Run's function in DB.
	 * 
	 * @param functionName
	 *            The name of the function to be called.
	 * @param inputVariables
	 *            input variables of the function
	 * @return ArrayList<String> each element is an string of single row from DB
	 *         with comma separated.
	 */
	public ArrayList<String> runDBFunction(String functionName, String inputVariables) {
		ArrayList<String> result = new ArrayList<>();
		try {
			System.out.println(functionName + "('" + inputVariables + "')");
			// create callable statement for function call with input variables.
			CallableStatement cs;
			if (inputVariables != null)
				cs = connection.prepareCall("{? = call " + functionName + "('" + inputVariables + "')}");
			else
				cs = connection.prepareCall("{? = call " + functionName + "}");
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.execute();
			// The returned result is lines separated with $
			String[] lines = cs.getString(1).split("\\$");
			for (int i = 0; i < lines.length; i++)
				result.add(lines[i]);
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			result.add(e.getMessage());
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
		}

		return result;
	}

	public ArrayList<String> runDBFunctionTableTypeReturn(String functionName, String inputVariables, String returnType) {
		// need to use this function because of massive data sometimes from DB

		ArrayList<String> result = new ArrayList<>();
		CallableStatement stproc_stmt;
		try {
			String strCall = "{? = call " + functionName + "(?)}";
			stproc_stmt = connection.prepareCall(strCall);

			if (returnType == null)
				stproc_stmt.registerOutParameter(1, Types.VARCHAR);
			else if (returnType.equals("int"))
				stproc_stmt.registerOutParameter(1, Types.INTEGER);
			else
				stproc_stmt.registerOutParameter(1, Types.ARRAY, returnType);

			stproc_stmt.setString(2, inputVariables);
			stproc_stmt.executeUpdate();
			ARRAY array_to_pass = null;
			try {
				array_to_pass = (ARRAY) stproc_stmt.getObject(1);
			} catch (ClassCastException e) {
				String[] lines = stproc_stmt.getString(1).split("\\$");
				for (int i = 0; i < lines.length; i++)
					result.add(lines[i]);
				stproc_stmt.close();
				return result;
			}
			Datum[] elements = array_to_pass.getOracleArray();
			for (int i = 0; i < elements.length; i++) {
				Object[] element = ((STRUCT) elements[i]).getAttributes();
				String tempStr = "";
				for (int j = 0; j < element.length; j++) {
					if (element[j] == null)
						tempStr += ",";
					else
						tempStr += element[j].toString() + ",";
				}
				tempStr = tempStr.substring(0, tempStr.length() - 1);
				result.add(tempStr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<String> runDBFunctionTableTypeReturn(String functionName, int inputVar1, int inputVar2,
			String returnType) {
		ArrayList<String> result = new ArrayList<>();
		CallableStatement stproc_stmt;
		try {
			String call = "{? = call " + functionName + "(?,?)}";
			stproc_stmt = connection.prepareCall(call);

			if (returnType == null)
				stproc_stmt.registerOutParameter(1, Types.VARCHAR);
			else if (returnType.equals("int"))
				stproc_stmt.registerOutParameter(1, Types.INTEGER);
			else
				stproc_stmt.registerOutParameter(1, Types.ARRAY, returnType);

			stproc_stmt.setInt(2, inputVar1);
			stproc_stmt.setInt(3, inputVar2);
			System.out.println(call);

			stproc_stmt.executeUpdate();

			ARRAY array_to_pass = (ARRAY) stproc_stmt.getObject(1);
			Datum[] elements = array_to_pass.getOracleArray();
			for (int i = 0; i < elements.length; i++) {
				Object[] element = ((STRUCT) elements[i]).getAttributes();
				String tempStr = "";
				for (int j = 0; j < element.length; j++) {
					if (element[j] == null)
						tempStr += ",";
					else
						tempStr += element[j].toString() + ",";
				}
				tempStr = tempStr.substring(0, tempStr.length() - 1);
				result.add(tempStr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Run's procedure in DB.
	 * 
	 * @param procedureName
	 *            The name of the procedure to be called.
	 * @param inputVariables
	 *            input variables of the procedure
	 * @param INSERT_ROW
	 *            procedure example:
	 *            LOCATION_ID,STREET_ADDRESS,POSTAL_CODE,CITY,STATE_PROVINCE,COUNTRY_ID
	 *            "INSERT_ROW","'LOCATIONS','11,''HAMESILA'',37000,''TEL-AVIV'',''YAYA'',''AR'''"
	 */
	public String runDBProcedure(String procedureName, String inputVariables) {
		String res = null;
		try {
			System.out.println("{call " + procedureName + "(" + inputVariables + ")}");
			CallableStatement cs = connection.prepareCall("{call " + procedureName + "(" + inputVariables + ")}");
			cs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			res = e.getMessage();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
		}

		return res;
	}


	/**
	 * Loads JDBC oracle driver and create connection with DB.
	 * 
	 * @param host,
	 *            The host name to connect to
	 * @param username,
	 *            DB user name
	 * @param passwrod,
	 *            DB user password
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void loadDriverAndConnnect(String user, String password) throws SQLException, ClassNotFoundException {
		Class.forName(SQL_DRIVER_NAME);
		connection = DriverManager.getConnection(URL, user, password);
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	}

	/**
	 * close current connection with DB.
	 */
	public void closeConnection() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
		}
	}
	

//	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		Class.forName(SQL_DRIVER_NAME);
//		Connection conn;
//		conn = DriverManager.getConnection(URL, "oreltest", "1234");
//		Statement state;
//		state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//	}
}