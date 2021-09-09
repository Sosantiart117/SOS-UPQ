import java.util.*;

class b5_10 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args){
		for(int i=1;i<6;i++){
			for(int j=10;j<16;j++){
				System.out.printf("%d,%-6d", j,i);
			}
			System.out.print("\n");
		}
	}
}
