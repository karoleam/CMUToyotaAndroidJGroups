package cmu.practicum.app;

import java.util.List;

import org.jgroups.blocks.ResponseMode;
import org.jgroups.util.RspList;

import cmu.practicum.JgroupsRpc;

public class SampleApp {
	

	public static void main (String[] args) throws Exception{
//		if(args.length!=1){
//			System.out.println("Syntax ! SampleApp <process|query>");
//			System.exit(1);
//		}
		JgroupsRpc jrpc= JgroupsRpc.getInstance();
//		if(args[0].equalsIgnoreCase("process")){
			jrpc.start();
			while(true){
				Thread.sleep(1000);
			}
//		}
		
		
		//--------------query
		
//		else if (args[0].equalsIgnoreCase("query"))
//
//
//			 jrpc= JgroupsRpc.getInstance();
//		try {
//			jrpc.start();
//			int count=10;
//			while(count>0){
//				RspList<VehicleDistance> rsp_list=jrpc.dispatch(ResponseMode.GET_ALL, 5000, new VehicleDistance(), VehicleDistance.class);
//				List<VehicleDistance> it= rsp_list.getResults();
//				for (VehicleDistance sinfo: it){
//					System.out.println("Vehiclename =" +sinfo.vehiclename +" , " +" distance="+ sinfo.distance);
//				}
//				System.out.println("***************");
//
//				Thread.sleep(5000);
//				count--;
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//--------------query
		
		
	}
}