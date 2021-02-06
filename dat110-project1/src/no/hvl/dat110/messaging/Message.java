package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		this.payload = payload; // TODO: check for length within boundary
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded = new byte[128];
		Integer padding = 0;
		
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		
		Integer messageLength = payload.length;
		encoded[0] = messageLength.byteValue();
		for (int i = 1; i < 128; i++) {
			if (i <= messageLength) {
				encoded[i] = payload[i-1];
			}
			else {
				encoded[i] = padding.byteValue();
			}
		}

		return encoded;
		
	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it 
		// in the payload of this message
		int messageLength = received[0];
		byte[] newPayload = new byte[messageLength];
		for (int i = 1; i <= messageLength; i++) {
			newPayload[i-1] = received[i];
		}
		
		this.payload = newPayload;
		
		
		
	}
}
