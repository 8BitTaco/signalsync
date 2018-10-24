public class Triangle extends Signal {
    @Override
    public float getSample(long us) {
        if(us <= 250000){
            float usf2 = (float)us;
            usf2 /= 250000.0f;
            return usf2;
        } else if(us <=750000){
            float usf3 = (float)us;
            usf3 /= 250000.0f;
            usf3 -= 2.0f;
            usf3 *= -1.0f;
            return usf3;
        } else if(us <=100000){
            float usf4 = (float)us;
            usf4 -= 750000.0f;
            usf4 /= 250000.0f;
            float usf =  1.0f - usf4;
            return usf;
        } else{
            return 0.0f;
        }
    }
}
