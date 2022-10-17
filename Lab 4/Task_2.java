import java.util.ArrayList;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);       
        System.out.println("Enter the number of the process for Priority Scheduling : ");
        int n=in.nextInt();
        Process_2[] a;
        a=new Process_2[n];
        System.out.println("Enter process name for Priority Scheduling , process arrival time, process burst time and process priority sequentially: ");
        for (int i=0;i<n;i++) {
            String p_name=in.next();
            int arrival_time=in.nextInt();
            int burst_time=in.nextInt();
            int priority=in.nextInt();
            a[i]=new Process_2(p_name,arrival_time,burst_time,priority);

        }

        int current_time=0;
        int completed_process=0;
        ArrayList<Process_2> ready_queue=new ArrayList();
        while (completed_process<n) {
            if (ready_queue.size() + completed_process<n) {
                for (int i=0;i<n;i++) {
                    if (a[i].arrival_time==current_time) {
                        ready_queue.add(a[i]);
                    }
                }
            }
            if (ready_queue.size()!=0) {
                Process_2 p=a[0];
                for (int i=0;i<n;i++) {
                    if (a[i].remaining_burst_time!=0 && ready_queue.contains(a[i])) {
                        p=a[i];
                        break;
                    }
                }
                for (int i=0;i<ready_queue.size();i++) {
                    Process_2 q=ready_queue.get(i);
                    if (q.priority<p.priority || (q.priority==p.priority && q.arrival_time<p.arrival_time)) {
                        p=q;
                    }
                }
                if (p.start_time==-1) {
                    p.start_time=current_time;
                }
                p.remaining_burst_time--;
                if (p.remaining_burst_time==0) {
                    p.end_time=current_time + 1;
                    p.waiting_time=p.end_time - p.arrival_time - p.burst_time;
                    p.turnaround_time=p.end_time - p.arrival_time;
                    completed_process++;
                    ready_queue.remove(p);
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
        System.out.println("Average Turnaround Time = " + (1.0 * total_turnaround_time / n));
        System.out.println("Average Waiting Time = " + (1.0 * total_waiting_time / n));

    }
}

class Process_2 
{

    String p_name;
    int arrival_time;
    int burst_time;
    int priority;
    int start_time=-1;
    int end_time=-1;
    int remaining_burst_time;
    int waiting_time=-1;
    int turnaround_time=-1;

    Process_2(String name,int x,int y,int z){
        this.p_name=name;
        arrival_time=x;
        burst_time=y;
        remaining_burst_time=y;
        priority=z;
    }
}
