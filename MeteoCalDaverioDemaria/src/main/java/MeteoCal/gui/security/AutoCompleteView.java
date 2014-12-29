/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import java.util.List;
import java.util.ArrayList;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Matteo
 */
public class AutoCompleteView {
    
    private Theme theme;
    
    @ManagedProperty("#{themeService}")
    private ThemeService service;
    
    public List<Theme> completeTheme(String query) {
        List<Theme> allThemes = service.getThemes();
        List<Theme> filteredThemes = new ArrayList<Theme>();
         
        for (int i = 0; i < allThemes.size(); i++) {
            Theme skin = allThemes.get(i);
            if(skin.getName().toLowerCase().startsWith(query)) {
                filteredThemes.add(skin);
            }
        }
         
        return filteredThemes;
    }
    
    public Theme getTheme() {
        return theme;
    }
 
    public void setTheme(Theme theme) {
        this.theme = theme;
    }
    
}
