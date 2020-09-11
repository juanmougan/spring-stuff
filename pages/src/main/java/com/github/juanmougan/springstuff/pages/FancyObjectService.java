package com.github.juanmougan.springstuff.pages;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class FancyObjectService implements InitializingBean {

  private List<FancyObject> fancyObjects;

  private static final int PAGE_SIZE = 20;
  private static final int PAGES_WANTED = 3;
  private static final int ELEMENTS_TO_COMPLETE_LAST_PAGE = 3;

  public List<FancyObject> listAll() {
    return fancyObjects;
  }

  public List<FancyObject> filterBy(final FancyObjectFilterRequest filterRequest) {
    return fancyObjects.stream()
        .filter(o -> nameMatches(filterRequest).test(o.getName()))
        .filter(o -> dateAfter(filterRequest).test(o.getCreatedAt()))
        .collect(Collectors.toList());
  }

  private Predicate<String> nameMatches(final FancyObjectFilterRequest filterRequest) {
    return n -> {
      if (!Strings.isNullOrEmpty(filterRequest.getNameEqualTo())) {
        return filterRequest.getNameEqualTo().equals(n);
      } else {
        return true;
      }
    };
  }

  private Predicate<LocalDateTime> dateAfter(final FancyObjectFilterRequest filterRequest) {
    return ldt -> {
      if (filterRequest.getCreatedAfter() != null) {
        return filterRequest.getCreatedAfter().isBefore(ldt);
      } else {
        return true;
      }
    };
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    final ImmutableList.Builder<FancyObject> fancyObjectBuilder = new ImmutableList.Builder<>();
    for (int i = 0; i < PAGE_SIZE * PAGES_WANTED - ELEMENTS_TO_COMPLETE_LAST_PAGE; i++) {
      fancyObjectBuilder.add(
          new FancyObject(NamesGenerator.getName(i), LocalDateTime.now().minus(Duration.ofSeconds(i)))
      );
    }
    fancyObjects = fancyObjectBuilder.build();
  }
}
