public static void extractFile(String filename) {
        try {
            String str = System.getProperty("user.dir") + "\\" + filename;
            String outputFile = str.replaceAll("\\\\|/", "\\"+System.getProperty("file.separator"));
            InputStream input = new BufferedInputStream(ExtractFile.class.getClassLoader().getResourceAsStream(filename));
            OutputStream output = new BufferedOutputStream(new FileOutputStream(outputFile));
            byte[] buffer = new byte[2048];
            for (;;) {
                int content = input.read(buffer);
                if (content <= 0) {
                    break;
                }
                output.write(buffer, 0, content);
            }
           System.out.println(filename + " file extracted to " + outputFile);
            output.flush();
            output.close();
            input.close();
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
