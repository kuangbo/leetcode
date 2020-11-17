package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _690 {
    int finalImportance = 0;
    public int getImportance(List<Employee> employees, int id) {
        // 使用map集合存储所有的employees及其对应的id
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees)
            map.put(e.id, e);
        dfs(id, map);
        return finalImportance;
    }
    public void dfs(int id, Map<Integer, Employee> map) {
        finalImportance += map.get(id).importance;
        for(int children : map.get(id).subordinates)
            dfs(children, map);
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
}
