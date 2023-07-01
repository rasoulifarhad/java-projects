package com.farhad.example.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IOStreamsDemoTest {

    @Test
    public void demonstrateUseByteStreamsToCopyFileOneByteAtATime() throws IOException {
        String srcfileName = "src/main/resources/sourceFile.txt";
        String destFileName = "src/main/resources/destByteOutputFile.txt";
        IOStreamsDemo.copyWithByteStream(srcfileName, destFileName);
    }

    @Test
    public void demonstrateCharacterStreamsToCopyFileOneCharacterAtATime() throws IOException {
        String srcfileName = "src/main/resources/sourceFile.txt";
        String destFileName = "src/main/resources/destCharacterOutputFile.txt";
        IOStreamsDemo.copyWithCharacterStream(srcfileName, destFileName);
    }

    @Test
    public void demonstrateCharacterStreamsToCopyFileOneLineAtATime() throws IOException {
        String srcfileName = "src/main/resources/sourceFile.txt";
        String destFileName = "src/main/resources/destLineOutputFile.txt";
        IOStreamsDemo.copyLines(srcfileName, destFileName);
    }

    // By default, a scanner uses white space to separate tokens. (White space characters include blanks, tabs, and line terminators. For the 
    // full list, refer to the documentation for Character.isWhitespace.(https://docs.oracle.com/javase/8/docs/api/java/lang/Character.html#isWhitespace-char-))
    //
    // Scanner also supports tokens for all of the Java language's primitive types (except for char), as well as BigInteger and BigDecimal. Also, 
    // numeric values can use thousands separators. Thus, in a US locale, Scanner correctly reads the string "32,767" as representing an integer 
    // value.
    // 
    // We have to mention the locale, because thousands separators and decimal symbols are locale specific.
    @Test
    public void demonstrateScannerReadIndividualWordsFromFileAndPrintThemOut() throws IOException {
        String fileName = "src/main/resources/sourceFile.txt";
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            while ( scanner.hasNext() ) {
                log.info("{}", scanner.next());
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    @Test
    public void demonstrateScannerReadIndividualLinesFromFileAndPrintThemOut() throws IOException {
        String fileName = "src/main/resources/sourceFile.txt";
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            while( scanner.hasNextLine() ) {
                log.info("{}", scanner.nextLine());
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    @Test
    public void demonstrateScannerReadIndividualTokensFromFileAndPrintThemOutUsingDelimiter() throws IOException {
        String fileName = "src/main/resources/sourceFile.txt";
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            scanner.useDelimiter(", ");
            while(scanner.hasNext()) {
                log.info("{}", scanner.next());
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }   
    
    // The output string is "xxxxxx.xxxxxx". The period will be a different character in some locales, because System.out is a PrintStream 
    // object, and that class doesn't provide a way to override the default locale. We could override the locale for the whole program — or 
    // we could just use formatting(https://docs.oracle.com/javase/tutorial/essential/io/formatting.html).
    @Test
    public void demonstrateScannerThatReadsListOfDoubleValueAndSumThemUp() throws IOException {
        String fileName = "src/main/resources/usnumbers.txt";
        Scanner scanner = null;
        double sum = 0;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            scanner.useLocale(Locale.US);
            while ( scanner.hasNext() ) {
                if (scanner.hasNextDouble()) {
                    double d = scanner.nextDouble();
                    log.info("{} is double", d);
                    sum += d;
                } else {
                    String s = scanner.next();
                    log.info("{} is not double", s);
                }
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        log.info("Sum: {}", sum);
    }

    // Stream objects that implement formatting are instances of either PrintWriter, a character stream class, or PrintStream, a byte stream class.
    //
    // Like all byte and character stream objects, instances of PrintStream and PrintWriter implement a standard set of write methods for simple 
    // byte and character output. In addition, both PrintStream and PrintWriter implement the same set of methods for converting internal data 
    // into formatted output. Two levels of formatting are provided:
    // 
    // - print and println format individual values in a standard way.
    // - format formats almost any number of values based on a format string, with many options for precise formatting.
    //
    // The i and r variables are formatted twice: the first time using code in an overload of print, the second time by conversion code 
    // automatically generated by the Java compiler, which also utilizes toString. 
    @Test
    public void demonstrateIOStreamFormattingWithPrintAndPrintlnMethodsOfPrintStream() {
        int i = 2; 
        double r = Math.sqrt(i);

        System.out.print("The square root of ");
        System.out.print(i);
        System.out.print(" is ");
        System.out.print(r);
        System.out.println(".");

        i = 5;
        r = Math.sqrt(i);
        System.out.println("The square root of " + i + " is " + r + ".");
    }

    // The format method formats multiple arguments based on a format string. The format string consists of static text embedded with format 
    // specifiers; except for the format specifiers, the format string is output unchanged.
    //
    //  For a complete description, see format string syntax in the API specification.(https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#syntax)
    // 
    // all format specifiers begin with a % and end with a 1- or 2-character conversion that specifies the kind of formatted output being 
    // generated. The three conversions used here are:
    // 
    // - d formats an integer value as a decimal value.
    // - f formats a floating point value as a decimal value.
    // - n outputs a platform-specific line terminator.
    // 
    // Here are some other conversions:
    // 
    // - x formats an integer as a hexadecimal value.
    // - s formats any value as a string.
    // - tB formats an integer as a locale-specific month name.
    // 
    // Except for %% and %n, all format specifiers must match an argument. If they don't, an exception is thrown.
    // In the Java programming language, the \n escape always generates the linefeed character (\\u000A). Don't use \n 
    // unless you specifically want a linefeed character. To get the correct line separator for the local platform, 
    // use %n.
    //
    // In addition to the conversion, a format specifier can contain several additional elements that further customize the formatted output.
    @Test
    public void demonstrateIOStreamFormattingWithFormatMethod() {
        int i = 2;
        double r = Math.sqrt(i);
        System.out.format("The square root of %d is %f.%n", i, r);
    }

    // %1$+020.10f
    // - Begin format specifier(%)
    // - Argument index(1$)
    // - Flags(+0)
    // - Width(20)
    // - Precision(.10)
    // - Conversion(f)
    //
    // Working from the right, the optional elements are:
    // 
    // - Precision. For floating point values, this is the mathematical precision of the formatted value. For s and other general conversions, this is the maximum width of the formatted value; the value is right-truncated if necessary.
    // - Width. The minimum width of the formatted value; the value is padded if necessary. By default the value is left-padded with blanks.
    // - Flags specify additional formatting options. In the Format example, the + flag specifies that the number should always be formatted with a sign, and the 0 flag specifies that 0 is the padding character. Other flags include - (pad on the right) and , (format number with locale-specific thousands separators). Note that some flags cannot be used with certain other flags or with certain conversions.
    // - The Argument Index allows you to explicitly match a designated argument. You can also specify < to match the same argument as the previous specifier. Thus the example could have said: System.out.format("%f, %<+020.10f %n", Math.PI);
    //
    @Test
    public void demonstrateIOStreamFormatingWithFormatMethodAndCustomizeFormattedOoutput() {
        System.out.format("%f, %1$+020.10f %n", Math.PI);
        System.out.format("%f, %<+20.10f %n", Math.PI);
        System.out.format("%f, %<+020.10f %n", Math.PI);
   }
}


