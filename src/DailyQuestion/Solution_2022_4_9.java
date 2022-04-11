package DailyQuestion;

public class Solution_2022_4_9 {
    /*
        780 到达终点
        感觉像是一道数学题，找出数学规律就容易得解了
     */
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while(tx >= sx && ty >=sy){
            if(ty > tx){
                if(tx > sx){
                    ty = ty % tx;
                }else if(tx == sx){
                    if((ty - sy) % sx == 0) return true;
                    else return false;
                }else{
                    return false;
                }
            }else if(ty < tx){
                if(ty > sy){
                    tx = tx % ty;
                }else if(ty == sy){
                    if((tx - sx) % sy == 0) return true;
                    else return false;
                }else{
                    return false;
                }
            }else{
                break;
            }
            if(sx == tx && sy == ty) return true;
        }
        if(sx == tx && sy == ty) return true;
        else return false;
    }
}
