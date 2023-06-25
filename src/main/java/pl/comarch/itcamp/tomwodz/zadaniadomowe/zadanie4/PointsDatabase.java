package pl.comarch.itcamp.tomwodz.zadaniadomowe.zadanie4;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PointsDatabase {
    private List<Point> pointsDatabase = new ArrayList<>();

    public List<Point> getAllPoints(){
        return this.pointsDatabase;
    }

    public Point getPoint(int id){
        return this.pointsDatabase.get(id);
    }

    public void persistPoint(Point point){
        this.pointsDatabase.add(point);
    }

}
