package webApp; /**
 * Created by sachin on 24/2/18.
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.regex.Pattern;

@Configuration
@Import(DatabaseConfig.class)
@ComponentScan(basePackages = "webApp",
        excludeFilters={
                @ComponentScan.Filter(type= FilterType.CUSTOM, value= RootContext.WebPackage.class)
        })
public class RootContext {
        public static class WebPackage extends RegexPatternTypeFilter {
                public WebPackage() {
                        super(Pattern.compile("webApp\\.webControllers"));
                }
        }

}
