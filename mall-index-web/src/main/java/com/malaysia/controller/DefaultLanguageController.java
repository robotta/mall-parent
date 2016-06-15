package com.malaysia.controller;

import com.malaysia.core.language.LangeuageLocale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by zhaoyun on 2016/5/19.
 */
@Controller
public class DefaultLanguageController {

    @Autowired
    private CookieLocaleResolver cookieLocaleResolver;
    /**
     * set Locale
     * @author zhaoyun
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/language")
    public ModelAndView language(HttpServletRequest request, HttpServletResponse response, String language, String red) {
        language=language.toLowerCase();
        if(language==null||language.equals("")){
            return new ModelAndView("redirect:/"+red);
        }else{
            if(language.equals("zh_cn")){
                cookieLocaleResolver.setLocale(request, response, Locale.CHINA );
            }else if(language.equals("en_us")){
                cookieLocaleResolver.setLocale(request, response, Locale.ENGLISH );
            }else if(language.equals("en_id")){
                cookieLocaleResolver.setLocale(request, response, LangeuageLocale.YINNI);
            }else if(language.equals("en_th")){
                cookieLocaleResolver.setLocale(request, response, LangeuageLocale.TAIGUO);
            }else if(language.equals("en_my")){
                cookieLocaleResolver.setLocale(request, response,LangeuageLocale.MALAYSIA);
            }
        }
        return new ModelAndView("redirect:"+red);
    }

}
