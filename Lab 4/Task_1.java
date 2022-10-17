import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);        
        System.out.println("Enter the number of the process for SJF Scheduling : ");
        int n=in.nextInt();
        Process[] a;
        a=new Process[n];
        System.out.println("Enter process name for SJF Scheduling, process arrival time, process burst time sequentially : ");
        for (int i=0; i<n; i++) {
            String p_name=in.next();
            int arrival_time=in.nextInt();
            int burst_time=in.nextInt();
            a[i]=new Process(p_name,arrival_time,burst_time);
        }

        int current_time=0;
        int completed_process=0;
        ArrayList<Process> ready_queue=new ArrayList();
        while (completed_process<n){
            if (ready_queue.size()+completed_process < n) {
                for (int i=0;i<n;i++) {
                    if (a[i].arrival_time==current_time) {
                        ready_queue.add(a[i]);
                    }
                }
            }

            if (ready_queue.size()!= 0) {
                Process p=a[0];
                for (int i=0;i<n;i++) {
                    if (a[i].remaining_burst_time!=0 && ready_queue.contains(a[i])) {
                        p=a[i];
                        break;
                    }
                }
                for (int i=0;i<ready_queue.size();i++) {
                    Process q=ready_queue.get(i);
                    if (q.remaining_burst_time<p.remaining_burst_time || (q.remaining_burst_time==p.remaining_burst_time && q.arrival_time<p.arrival_time)) {
                        p=q;
                    }
                }
                if (p.start_time==-1) {
                    p.start_time=current_time;
                }
                p.remaining_burst_time--;
                if (p.remaining_burst_time==0) {
                    p.end_time=current_time+1;
                    p.waiting_time=p.end_time-p.arrival_time-p.burst_time;
                    p.turnaround_time=p.end_time-p.arrival_time;
                    completed_process++;
                    ready_queue.remove(p);
                }
            }

            current_time++;
        }

        int total_waiting_time=0;
        int total_turnaround_time=0;
        for (int i=0;i<n;i++) {
            total_waiting_time+=a[i].waiting_time;
            total_turnaround_time+=a[i].turnaround_time;
            System.out.println("Process name = "+a[i].p_name+", start time = "+a[i].start_time+", end time = "+a[i].end_time+ ", turnaround time =  " + a[i].turnaround_time+ ", waiting time = " + a[i].waiting_time);
        }

        System.out.println("Average Turnaround Time = " + (1.0 * total_turnaround_time / n));
        System.out.println("Average Waiting Time = " + (1.0 * total_waiting_time / n));

    }
}


class Process {

    String p_name;
    int arrival_time;
    int burst_time;
    int start_time=-1;
    int end_time=-1;
    int remaining_burst_time;
    int waiting_time=-1;
    int turnaround_time=-1;


    Process(String name, int a, int b) {
        this.p_name=name;
        arrival_time=a;
        burst_time=b;
        remaining_burst_time=b;
    }

}
