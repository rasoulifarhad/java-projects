package com.farhad.example.design_principles02.good_code.srp.good;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.farhad.example.design_principles02.good_code.srp.JobEvent;
import com.farhad.example.design_principles02.good_code.srp.JobListener;
import com.farhad.example.design_principles02.good_code.srp.PrintServer;
import com.farhad.example.design_principles02.good_code.srp.ServiceAdvanced;

public class PrintServerImpl extends ServiceAdvanced implements PrintServer, JobListener {
	
	private Map<String, PrinterServerJob> printerServerJob = new HashMap<>();
	private JobEventListener jobEventListener;
	private PrinterList printerList;

	public PrinterServerJob getJob(String jobId) {
		return printerServerJob.get(jobId);
	}
	public Vector<?> getPrinterList() {
		return printerList.getPrinterList();
	}

	public synchronized void setPrinterList(Vector<?> printerList) {
		this.printerList.setPrinterList(printerList);
	}

	public void statusChanged(JobEvent jobEvent) {
		jobEventListener.statusChanged(jobEvent);
	}

	public void pageComputed(JobEvent jobEvent) {
		jobEventListener.pageComputed(jobEvent);
	}	
}
