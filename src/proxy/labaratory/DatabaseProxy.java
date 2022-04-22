package proxy.labaratory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

interface Database{
    void getWeatherByLocation();
}

class RealDatabase implements Database{
    private String location;
    private String weather;
    public RealDatabase(String location){
        this.location = location;
        this.weather = getWeather();
    }
    public String getWeather(){
        int x = (int) Math.floor((Math.random() * 5) + 2);
        int y = (int) Math.floor((Math.random() * 5) + 2);
        return String.valueOf(x) + "." + String.valueOf(y);
    }
    @Override
    public void getWeatherByLocation(){
        System.out.println("Weather in " + this.location + ": " + this.weather);
    }
}

class CachedDatabase implements Database{
    private RealDatabase db;
    private Date cacheDate;
    private String location;
    private long reloadTime;
    public CachedDatabase(String location){
        this.location = location;
        this.reloadTime = 2000;
    }

    public long getReloadTime() {
        return reloadTime;
    }

    public void setReloadTime(long reloadTime) {
        this.reloadTime = reloadTime;
    }

    @Override
    public void getWeatherByLocation() {
        if(this.cacheDate == null){
            this.cacheDate = new Date();
        }
        long duration = new Date().getTime() - this.cacheDate.getTime();
        if(this.db == null || duration > reloadTime){
            System.out.println("Request to server...");
            this.db = new RealDatabase(this.location);
            this.cacheDate = new Date();
        }
        else{
            System.out.println("Upload from cache...");
        }
        System.out.println(cacheDate);
        this.db.getWeatherByLocation();
    }
}
class ProxyRun{
    public static void sleep(int seconds){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Database db = new CachedDatabase("Almaty");
        db.getWeatherByLocation();
        sleep(1);
        db.getWeatherByLocation();
        sleep(2);
        db.getWeatherByLocation();
    }
}
