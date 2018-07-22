import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Driver {

	public static void main(String args[]) throws IOException {
		Linked[] d = new Linked[114];
		File test = new File("test.txt");
		Scanner l = new Scanner(test);
		String lines = l.nextLine();
		while (l.hasNextLine() == true) {
			lines += l.nextLine();
		}
		lines = lines.replaceAll("»”„ «··Â «·—Õ„‰ «·—ÕÌ„", ",");
		lines = lines.replaceAll("[)1234567890]", "");
		lines = lines.trim().replace("(", " ");
		String[] x = lines.split(",");
		l.close();
		
		PrintStream o = new PrintStream("Idone.txt");
		int z = 0;
		for (int j = 0; j < x.length; j++) {
			String[] c = x[j].split(" ");
			int k = 0;
			String aya = "";
			for (int i = 0; i < c.length; i++) {
				if (c[i].length() != 0) {
					z = 1;
					aya += c[i] + " ";
				}

				else if (z == 1) {
					k++;
					aya += ">";
					z = 0;
				}
			}

			k++;
			String[] test1 = aya.split(">");
			d[j] = new Linked(k);
			for (int i = 0; i < test1.length; i++) {
				d[j].add(test1[i]);
			}

		}
		for (int i = 0; i < d.length; i++) {
			o.println((i + 1));
			for (int j = 0; j < d[i].con; j++) {
				o.println(d[i].getindex(j).replaceAll("	 ", "") + "<" + (j + 1));
			}
		}
		o.close();
	}
}
