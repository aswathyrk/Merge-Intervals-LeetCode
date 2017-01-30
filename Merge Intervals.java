/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals==null || intervals.size()==0)return result;
        if(intervals.size()==1)return intervals;
        
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval a,Interval b){
                if(a.start!=b.start){
                    return a.start-b.start;
                }
                else{
                    return a.end-b.end;
                }
            }
        }
        );
        
        int start,end;
        
        Interval i1=intervals.get(0);Interval i2;
        for(int j=1;j<intervals.size();j++){
            i2=intervals.get(j);
            if(i2.start>i1.end){
                result.add(i1);
                i1=i2;
            }
            else{ // if(i2.start<=i1.end)
                start=i1.start;
                end=Math.max(i2.end,i1.end);
                Interval intnew=new Interval(start,end);
                i1=intnew;
            }
        }
        
        result.add(i1);
        return result;    
        
    }
}