import java.util.*;
import java.io.*;
/*
	Problem statement -
	Make buckets of strings that are related to each other.
	Relation is described as- 

	example. -  "abc" has relation with "xyz" since. adding 1 to a gives b and adding 1 to b gives c , and same happens for xyz. x + 1 -> y + 1 -> z

*/




class MakeStringBuckets {
/*
	Solution approach -
	for a given string, we will be storing it in hashmap, which has a mapping from hashValue to buckets.
	The hashValue will be defined as the string (made of numbers) - which is formed by subtracting 
	the index (Integer) value from all the other (Integer) values.
*/

	static String getHashValue(String str) {
		String res = "";
		Character indexValue = str.charAt(0);

		for(int i = 0; i <str.length(); i++) {
			int diff = str.charAt(i) - indexValue;
			if(diff < 0) {
				diff = diff + 26;
			}
			System.out.println("diff " + diff);

			String Sdiff = String.valueOf(diff);

			if(Sdiff.length() == 1) {
				Sdiff = "0" + Sdiff;
			}

			res = res + Sdiff;
		}

		return res;
	}

	public static void printhashMap(HashMap<String, ArrayList<String>> hm) {
		Iterator i = hm.entrySet().iterator();

		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}

	public static void main(String[] args) throws IOException {
		// taking input
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(i);
		int numberOfStrings = Integer.valueOf(br.readLine());

		HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();

		System.out.println("TotalStrings :" + numberOfStrings);			
		while(numberOfStrings-- > 0) {
			String s = br.readLine();
			System.out.println("String : " + s );
			String hashVal = getHashValue(s);
			System.out.println("HashValue for string : " + s + " " + hashVal);
			ArrayList<String> get = hm.get(hashVal);
			if(get == null) {
				get = new ArrayList<String>();
			}

			get.add(s);
			hm.put(hashVal, get);
		}

		printhashMap(hm);

	}
}