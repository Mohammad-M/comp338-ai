
public class Linked {
String []ayat;
Documents f=new Documents();
int con=0;
public Linked(int size) {
	ayat=new String [size];
}
public void add(String text) {
	ayat[con++]=text;
}
public String  getindex(int i) {
	return ayat[i];
}
}
