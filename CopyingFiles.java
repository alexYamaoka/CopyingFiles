import java.io.*;

public class CopyingFiles
{
  // args[0] for source file
  // args[1] for target file


  public static void main(String[] args) throws IOException
  {
    // check command line parameter usage

    if (args.length != 2)
    {
      System.out.println("To Use Program, enter: java CopyingFiles sourceFile tagetFile");
      System.exit(1);
    }






    // check if source file exists

    File sourceFile = new File(args[0]);

    if (!sourceFile.exists())
    {
      System.out.println("Source File " + args[0] + " does not exist");
      System.exit(2);
    }





    // check if target file exists

    File targetFile = new File(args[1]);

    if (targetFile.exists())
    {
      System.out.println("Target File " + args[1] + " already exists");
      System.exit(3);
    }







    // copying the files

    try
    (
      BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));             // create input stream
      BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));         // create output stream
    )
    {
      // continuously read a byte from input and write it to output
      int value = 0;
      int numberOfBytesCopied = 0;


      while ( (value = input.read()) != -1 )
      {
        output.write((byte)value);
        numberOfBytesCopied++;
      }




      System.out.println("Number of Bytes copied: " + numberOfBytesCopied);
    }



  }
}
