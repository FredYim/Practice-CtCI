public HashMap<Integer, Student> buildMap(Student[] students) {
	HashMap<Integer, Student> map = new HashMap<Integer, Student>();
	for (Student s : students) map.put(s.getId(),s);
	return map;
}

public ArrayList<String> merge(String[] words, String[] more) {
	ArrayList<String> sentence = new ArrayList<string>();
	for (String w : woords) sentence.add(w);
	for (String m : more) sentence.add(m);
	return sentence;
}

public String joinWords(String[] words) {
	String sentence = "";
	for (String w : words) {
		sentence = sentence + w;
	}
	return sentence;
}

public String joinWords(String[] words) {
	StringBuffer sentence = new StringBuffer();
	for (String w : words) {
		sentence.append(w);
	}
	return sentence.toString();
}

///////////Questions////////////////////////////

//1.1
public boolean uniqueChar(String str) {
	if (str.length()>256) return false; //all ASCII characters

	boolean[] char_val = new boolean[256];

	for (int i=0;i<str.length();i++) {
		int val = str.chartAt(i);
		if (char_val[val]) return false;
		char_val[i] = true;
	}

	return true;
}

//1.3
//should ask about case sensitive and whitespace
public boolean permutation(String A, String B) {
	if (A.length()!=B.length()) return false;

	int[] char_setA = new int[256];

	for (int i=1; i<A.length(); i++) {
		int val = A.charAt(i);
		char_setA[val]++;
	}

	int[] char_setB = new int[256];

	for (int i=1; i<B.length(); i++) {
		int val = B.charAt(i);
		char_setB[val]++;
	}

	for (int i=0; i<256; i++) {
		if (char_setA[i] != char_setB[i]) return false;
	}

	return true;
}

//sample solution 1
public String sort(String s) {
	char[] content = s.toCharArray();
	java.util.Arrays.sort(content);
	return new String(content);
}

public boolean permutation(String s, String t) {
	if (s.length()!=t.length()) return false;

	return sort(s).equals(sort(t));
}

//sample solution 2
public boolean permutation(String s, String t) {
	if (s.length()!=t.length()) return false;

	int[] letters = new int[256];

	char[] s_array = s.toCharArray();
	for (char c : s_array) {
		letters[c]++;
	}

	for (int i=0;i<t.length();i++) {
		int c = t.chartAt(i);
		if (--letters[c]<0) return false;
	}
	return true;
}


//1.4
//sample solution
public void replaceSpaces(char[] str, int length) {
	int spaceCount 0; newLength, i = 0;
	for (i = 0; i <  length; i++) {
		if (str[i] == ' ') spaceCount++;
	}
	newLength = length + spaceCount*2;
	str[newLength] = '\0';
	for (i = length-1; i>=0; i--) {
		if(str[i]==' ') {
			str[newLength--] = '0';
			str[newLength--] = '2';
			str[newLength--] = '%';
		}
		else {
			str[newLength--] = str[i];
		}
	}
}

//1.5
public String compress(String str) {
	String result = "";

	char curr = str[0];
	int count = 1;
	for (int i=1; i<str.length();i++) {
		if(str.chartAt(i)==curr) count++;
		else {
			result = result + curr +count;
			curr = str.chartAt(i);
			count = 1;
		}
	}
	return result + curr + count;
}

//better solution
String compressBetter(String str) {
	int size = countCompression(str);
	if (size >= str.length()) return str;

	StringBuffer newstr = new StringBuffer();
	char last = str.charAt(0);
	int count = 1;
	for (i=1; i<str.length();i++) {
		if (str.chartAt(i)==last) {
			count++;
		} else {
			newstr.append(last);
			newstr.append(count);
			last = str.chartAt(i);
			count = 1;
		}
	}
	newstr.append(last);
	newstr.append(count);
	return newstr.toString();
}

int countCompression(String str) {
	char last = str.charAt(0);
	int size = 0;
	int count  = 1;
	for (i=1; i< str.length(); i++) {
		if (str.chartAt(i)==last) {
			count++
		} else {
			last = str.charAt(i);
			size += 1 + String.valueOf(count).length();
			count = 1;
		}
	}
	size += 1 + String.valueOf(count).length();
	return size;
}

//1.6
public E[][] rotate(int n,E[][] img) {
	E[] arr = new E[n*n];
	for (int i=0; i<n; i++)
		for (int j=0; j<n; j++)
			arr[i*n+j] = img[i][j];

	E[][] temp = new E[n][n];
	for (i=n; i>=0; i--)
		for (j=0; j<n; j++)
			temp[i][j] = arr[(n-i)*n+j];

	return temp;
}
//O(n^2)time and O(n)menory too much

//sample solution
public void rotate(int[][] matrix, int n) {
	for (int layer = 0; layer < n/2; ++layer) {
		int first = layer;
		int last  = n-1-layer;
		for (int i = first; i<last; ++i) {
			int offset = i -first;
			int top = matrix[first][i];
			matrix[first][i] = matrix[last-offset][first];
			matrix[last-offset][first] = matrix[last][last-offset];
			matrix[last][last-offset] = matrix[i][last];
			matrix[i][last] = top;
		}
	}
}

//1.7
public void setZero(int[][] matrix) {
	boolean[] row = new boolean[matrix.length];
	boolean[] column  = new boolean[matrix[0].length];

	for (int i = 0; i<matrix.length; i++)
		for (int j = 0; j<matrix[0].length; j++)
			if (matrix[i][j]==0) {
				row[i] = true;
				column[j] = true;
			}

	for (int i = 0; i<matrix.length;i++)
		for (int j = 0; j<matrix[0].length;j++)
			if (row[i]||column[j]) matrix[i][j] = 0;
}

//1.8
//rotation: xy --> yx
//so yx is always a substring of xyxy
public boolean rotation(String s1, String s2) {
	if(s1.length()==s2.length()) {
		String s1s1 = s1+s1;
		return is Substring(s1s1,s2);
	}
	return false;
}