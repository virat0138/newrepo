import java.io.*;

class AffineCipher
{
int k1,k2;
AffineCipher(int k1, int k2)
{
	this.k1 = k1;
	this.k2 = k2;
}
int encryption(int x)
{
	int c = (k1*x + k2) % 128;
	
	return c;
}

int decryption(int c)
{
	int inverse = 1;
	while((k1 * inverse) % 128 != 1)
	{
		inverse++;
	}
	int D = (inverse * (c - k2)) %128;
	return D;
}

public static void main(String args[])throws IOException
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter Value of k1 and k2: ");
	int n1 = Integer.parseInt(br.readLine());
	int n2 = Integer.parseInt(br.readLine());
	AffineCipher c = new AffineCipher(n1,n2);
	System.out.println("\n Encryption: ");
	int s = Integer.parseInt(br.readLine());
	System.out.println(c.encryption(s));
	System.out.println("\n Decryption: ");
	s = Integer.parseInt(br.readLine());
	System.out.println(c.decryption(s));
}
}