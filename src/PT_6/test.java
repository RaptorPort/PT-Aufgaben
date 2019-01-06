package PT_6;

import java.sql.Date;

public class test {

	public static void main(String[] args) {
		Integer l[] = {9,6,4,5,3,2,1,9,7,551,5,5,1,53,15,15,31153,53,153,1,1,135,1351,351,31,3,1,5,651,6351,6,531,56,1,651,65,1,651,651,65,165,1,651,563};
		Double d[] = {100.38, 2.56, 4.3, 11.641, 987.643};
		String s[] = {"come","cup","cold","church","allow","customer","bag","around","actually","cut","death","data","Democrat","affect","charge","author",
				"authority","always","change","break","challenge","chance","certainly","among","building","claim","base","book","buy","blood","citizen",
				"continue","but","attack","commercial","all","board","also","car","agent","decision","area","benefit","almost","bar","Congress","cover",
				"close","could","check","case","analysis","box","behavior","defense","create","call","about","dark","age","city","choose","daughter","at",
				"assume","cultural","because","act","century","according","appear","a","anyone","argue","decade","deal","apply","cell","community","away",
				"beat","cancer","brother","bank","arrive","again","condition","care","collection","after","ball","attention","current","agree","black","debate",
				};
		Date da[] = {new Date(1785,1,1), new Date(1,1,1999), new Date(3,3,2015)};
		
		genericSort t = new genericSort();
		
		t.printSortprint(l);
		t.printSortprint(d);
		t.printSortprint(s);
		t.printSortprint(da);
	}
	
	
}
