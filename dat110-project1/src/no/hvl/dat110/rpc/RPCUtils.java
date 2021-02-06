package no.hvl.dat110.rpc;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array
		
		byte[] stringAsBytes = str.getBytes();
		encoded = new byte[stringAsBytes.length + 1];
		encoded[0] = rpcid;
		
		for (int i = 1; i <= str.length(); i++) {
			encoded[i] = stringAsBytes[i-1];
		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded;

		// TODO: unmarshall String contained in data into decoded
		
		byte[] dataAfterZero = new byte[data.length -1];
		for (int i = 0; i < dataAfterZero.length; i++) {
			dataAfterZero[i] = data[i+1];
		}
		
		decoded = new String(dataAfterZero);

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded;

		// TODO: marshall RPC identifier in case of void type
		
		encoded = new byte[1];
		encoded[0] = rpcid;

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array
		ByteBuffer bb = ByteBuffer.allocate(4);
		bb.putInt(x);
		encoded = new byte[5];
		encoded[0] = rpcid;
		for (int i = 1; i < encoded.length; i++) {
			encoded[i] = bb.array()[i-1];
		}

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		// TODO: unmarshall integer contained in data
		
		byte[] dataAfterZero = new byte[data.length -1];
		for (int i = 0; i < dataAfterZero.length; i++) {
			dataAfterZero[i] = data[i+1];
		}
		
		ByteBuffer byteBuffer = ByteBuffer.wrap(dataAfterZero);
		decoded = byteBuffer.getInt();

		return decoded;

	}
}
