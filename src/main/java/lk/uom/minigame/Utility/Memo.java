package lk.uom.minigame.Utility;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

public class Memo {
    private RandomNumberGenerator randomNumberGenerator;
    private HashMap<String,CaseMemo> dict;
    private static Memo instance = null;
    private Memo() {
       dict = new HashMap<String,CaseMemo>();
       randomNumberGenerator = RandomNumberGenerator.getInstance();
    }
    public static Memo getInstance(){
        if(instance == null){
            instance = new Memo();
        }
        return instance;
    }
    public CaseMemo getCaseMemo(HttpServletRequest request){
        String sessionID = SessionHandler.getSessionID(request);
        if (!(dict.containsKey(sessionID))) {
            dict.put(sessionID,new CaseMemo(randomNumberGenerator.getRandomNumber(),1));
        }
        return dict.get(sessionID);
    }
    public void removeEntry(String sessionID){
        dict.remove(sessionID);
    }
    public void removeEntry(HttpServletRequest request){
        removeEntry(SessionHandler.getSessionID(request));
    }
    public void cleanDict(){
        dict = new HashMap<>();
        System.gc();
    }
}

