import model.Vertex;

public class Matrix3 {
    public double[] value;
    public Matrix3(double[] value){
        this.value=value;
    }
    public  Matrix3 multiply(Matrix3 other){
        double[] result = new double[9];
        for(int row =0; row<3;row++){
            for(int col=0; col<3; col++){
                for (int i=0;i<3;i++){
                    result[row*3+col] +=
                            this.value[row * 3+ i ] * other.value[i*3 + col];
                }
            }
        }
        return new Matrix3(result);
    }
    public Vertex transform(Vertex in){
        return new Vertex(
                in.x*this.value[0]+ in.y*this.value[1]+ in.z*this.value[2],
                in.x*this.value[3]+ in.y*this.value[4]+ in.z*this.value[5],
                in.x*this.value[6]+ in.y*this.value[7]+ in.z*this.value[8]
                );
    }
}
