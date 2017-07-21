package com.matthew.service;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.profiles.pegdown.Extensions;
import com.vladsch.flexmark.profiles.pegdown.PegdownOptionsAdapter;
import com.vladsch.flexmark.util.options.DataHolder;
import org.springframework.stereotype.Service;

/**
 * Created by huafu on 17-7-20.
 */
@Service
public class MarkdownParseService {
    static final DataHolder OPTIONS = PegdownOptionsAdapter.flexmarkOptions(
            Extensions.ALL
    );
    static Parser parser = Parser.builder(OPTIONS).build();
    static HtmlRenderer renderer = HtmlRenderer.builder(OPTIONS).build();

    public static String parseToHtml(String markdown){
        Node document = parser.parse(markdown);
        String html = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
        return html;
    }

}
