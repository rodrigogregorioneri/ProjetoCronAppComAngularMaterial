package auth.permission;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ScopedProxyMode;

@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
public class TenantComponent {

  private Map<String, String> contextIds = new HashMap<>();

  public void setId(String contextKey, String id) {
    contextIds.put(contextKey, id);
  }

  public Object getId(String contextKey) {
    return contextIds.get(contextKey);
  }

  public Map<String, String> getContextIds() {
    return contextIds;
  }
}