package helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static void main(String[] args) {

        final File folder = new File("G:/Ubuntu/INES/INES_Pilot/SVN/01. Requirements/JP/20_製造/DDL/table");

        List<String> listFilesName = new FileUtils().readingFiles(folder);

        String content = new FileUtils().concatContentInAllFiles(listFilesName);

        PrintWriter out = null;
        try {
            out = new PrintWriter("filename.txt");

            out.println(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

	public List<String> readingFiles(final File folder) {

		List<String> listFileName = new ArrayList<>();

		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				readingFiles(fileEntry);
			} else {
				listFileName.add(fileEntry.getAbsolutePath());
			}
		}

		return listFileName;
	}

	public String concatContentInAllFiles(List<String> listFilesName) {
		StringBuilder content = new StringBuilder();

		for (String fileName : listFilesName) {

			try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

				String line;
				while ((line = br.readLine()) != null) {
					content.append(line);
					content.append("\n");
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			
			content.append("\n");
		}

		return content.toString();
	}
}
