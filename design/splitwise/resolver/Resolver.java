
package design.splitwise.resolver;

import java.util.List;

import design.splitwise.dto.ResolvedShare;
import design.splitwise.model.Expense;

public interface Resolver {
    List<ResolvedShare> resolve(Expense expense);
}
