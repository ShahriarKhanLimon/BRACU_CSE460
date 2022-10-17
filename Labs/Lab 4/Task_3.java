import java.util.ArrayList;
import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the amount of time quantum for Round Robin Scheduling : ");
        int tq=in.nextInt();
        System.out.println("Enter the number of the Process of Round Robin: ");
        int n=in.nextInt();
        Process_3[] a;
        a=new Process_3[n];
        System.out.println("Enter Process name, Process arrival time, Process burst time sequentially : ");
        for (int i=0;i<n;i++) {
            String p_name=in.next();
            int arrival_time=in.nextInt();
            int burst_time=in.nextInt();
            a[i]=new Process_3(p_name, arrival_time, burst_time);

        }

        int current_time=0;
        int completed_Process=0;
        int available_quantum=tq;
        ArrayList<Process_3> ready_queue=new ArrayList();
        while (completed_Process<n) {
            if (ready_queue.size() + completed_Process<n) {
                for (int i=0;i<n;i++) {
                    if (a[i].arrival_time==current_time) {
                        ready_queue.add(a[i]);
                    }
                }
            }
            if (ready_queue.size()!=0) {
                Process_3 p=ready_queue.get(0);
                if (p.start_time==-1) {
                    p.start_time=current_time;
                }
                p.remaining_burst_time--;
                available_quantum--;
                if (p.remaining_burst_time==0) {
                    p.end_time=current_time + 1;
                    p.waiting_time=p.end_time - p.arrival_time - p.burst_time;
                    p.turnaround_time=p.end_time - p.arrival_time;
                    completed_Process++;
                    available_quantum=tq;
                    ready_queue.remove(p);
                } else if (available_quantum==0) {
                    available_quantum=tq;
                    ready_queue.remove(p);
                    ready_queue.add(p);
                }
            }
            current_time++;

        }
        int total_waiting_time=0;
        int total_turnaround_time=0;
        for (int i=0;i<n;i++) {
            total_waiting_time += a[i].waiting_time;
            total_turnaround_time += a[i].turnaround_time;
            System.out.println("Process name = " + a[i].p_name + ", start time = " + a[i].start_time + ", end time = " + a[i].end_time+ ", turnaround time = " + a[i].turnaround_time+ ", waiting time = " + a[i].waiting_time);
        }
        
        System.out.println("Average Turnaround Time =  " + (1.0 * total_turnaround_time / n));
        System.out.println("Average Waiting Time = " + (1.0 * total_waiting_time / n));
        

    }
}

class Process_3 
{

    String p_name;
    int arrival_time;
    int burst_time;
    int start_time=-1;
    int end_time=-1;
    int remaining_burst_time;
    int waiting_time=-1;
    int turnaround_time=-1;

    Process_3(String name,int x,int y) {
        this.p_name=name;
        arrival_time=x;
        burst_time=y;
        remaining_burst_time=y;
    }

}
