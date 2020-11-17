package competition;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: kuangbo
 * Date: 2020/9/27
 * Time: 上午11:24
 */
class ThroneInheritance {
    Map<String, LinkedList<String>> map = new HashMap<>();
    Set<String> deathSet = new HashSet<>();
    String king = null;

    public ThroneInheritance(String kingName) {
        map.put(kingName, new LinkedList<>());
        king = kingName;
    }

    public void birth(String parentName, String childName) {
        LinkedList<String> list = map.getOrDefault(parentName, new LinkedList<>());
        list.addLast(childName);
        map.putIfAbsent(parentName, list);
        map.putIfAbsent(childName, new LinkedList<>());
    }

    public void death(String name) {
        deathSet.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> now = new ArrayList<>();
        getChild(king, now);
        return now;
    }
    public void getChild(String root, List<String> res) {
        if("".equals(root) || root== null)
            return;
        res.add(root);
        if(deathSet.contains(root))
            res.remove(root);
        for (String child:map.get(root)) {
            getChild(child, res);
        }
    }
}
