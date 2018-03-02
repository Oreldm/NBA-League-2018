package utils;

import java.io.File;
import java.nio.file.Paths;

public interface FilesUtils {
	public static boolean isFileDirectoryExists(File file)

	{
		if (file.exists()) {
			return true;
		}
		return false;
	}

	public static boolean isDirectoryExists(String directoryPath)

	{
		if (Paths.get(directoryPath).toFile().isDirectory()) {
			return true;
		}
		return false;
	}
}
