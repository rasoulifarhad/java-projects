package com.farhad.example.javaidioms.interfacesindependentofimplementation;

import javax.naming.ldap.Control;

public class InterfacesIndependentOfImplementation {
	
	interface Protocol {
		void transmit(Message m) throws TransportException;
		void setReceiver(ProtocolReceiver r);// who gets called when messages arrive
		Control getControl(Class control_interface_class);
	}

	static class Message {}
	interface ProtocolReceiver {}
	interface control {
		// Empty - it just marks interfaces as being used to control protocol layers
	}

	interface ConnectionControl extends Control {
		void connect(Address to) throws TransportException;
		void close() throws TransportException;
		void shutdown() throws TransportException;
		void addConnectionListener(ConnectionListener l);
		void removeConnectionListener(ConnectionListener l);
	}

	static class Address {}
	static class TransportException extends RuntimeException {}
	interface ConnectionListener {}
}
