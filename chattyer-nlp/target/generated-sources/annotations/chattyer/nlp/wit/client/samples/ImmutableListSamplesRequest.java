package chattyer.nlp.wit.client.samples;

import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link ListSamplesRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableListSamplesRequest.builder()}.
 */
@Generated(from = "ListSamplesRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableListSamplesRequest extends ListSamplesRequest {
  private final String applicationId;
  private final long offset;
  private final List<String> entityIds;
  private final List<String> entityValues;

  private ImmutableListSamplesRequest(ImmutableListSamplesRequest.Builder builder) {
    this.applicationId = builder.applicationId;
    this.entityIds = createUnmodifiableList(true, builder.entityIds);
    this.entityValues = createUnmodifiableList(true, builder.entityValues);
    this.offset = builder.offsetIsSet()
        ? builder.offset
        : super.getOffset();
  }

  /**
   * @return The value of the {@code applicationId} attribute
   */
  @Override
  public String getApplicationId() {
    return applicationId;
  }

  /**
   * @return The value of the {@code offset} attribute
   */
  @Override
  public long getOffset() {
    return offset;
  }

  /**
   * @return The value of the {@code entityIds} attribute
   */
  @Override
  public List<String> getEntityIds() {
    return entityIds;
  }

  /**
   * @return The value of the {@code entityValues} attribute
   */
  @Override
  public List<String> getEntityValues() {
    return entityValues;
  }

  /**
   * This instance is equal to all instances of {@code ImmutableListSamplesRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableListSamplesRequest
        && equalTo((ImmutableListSamplesRequest) another);
  }

  private boolean equalTo(ImmutableListSamplesRequest another) {
    return applicationId.equals(another.applicationId)
        && offset == another.offset
        && entityIds.equals(another.entityIds)
        && entityValues.equals(another.entityValues);
  }

  /**
   * Computes a hash code from attributes: {@code applicationId}, {@code offset}, {@code entityIds}, {@code entityValues}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + applicationId.hashCode();
    h += (h << 5) + Long.hashCode(offset);
    h += (h << 5) + entityIds.hashCode();
    h += (h << 5) + entityValues.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ListSamplesRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "ListSamplesRequest{"
        + "applicationId=" + applicationId
        + ", offset=" + offset
        + ", entityIds=" + entityIds
        + ", entityValues=" + entityValues
        + "}";
  }

  /**
   * Creates a builder for {@link ImmutableListSamplesRequest ImmutableListSamplesRequest}.
   * <pre>
   * ImmutableListSamplesRequest.builder()
   *    .applicationId(String) // required {@link ListSamplesRequest#getApplicationId() applicationId}
   *    .offset(long) // optional {@link ListSamplesRequest#getOffset() offset}
   *    .entityId|addAllEntityIds(String) // {@link ListSamplesRequest#getEntityIds() entityIds} elements
   *    .entityValue|addAllEntityValues(String) // {@link ListSamplesRequest#getEntityValues() entityValues} elements
   *    .build();
   * </pre>
   * @return A new ImmutableListSamplesRequest builder
   */
  public static ImmutableListSamplesRequest.Builder builder() {
    return new ImmutableListSamplesRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableListSamplesRequest ImmutableListSamplesRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "ListSamplesRequest", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_APPLICATION_ID = 0x1L;
    private static final long OPT_BIT_OFFSET = 0x1L;
    private long initBits = 0x1L;
    private long optBits;

    private @Nullable String applicationId;
    private long offset;
    private List<String> entityIds = new ArrayList<String>();
    private List<String> entityValues = new ArrayList<String>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code chattyer.nlp.wit.client.samples.ListSamplesRequest} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ListSamplesRequest instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    /**
     * Fill a builder with attribute values from the provided {@code chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(AbstractApplicationScopedWitRequest instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    private void from(Object object) {
      if (object instanceof ListSamplesRequest) {
        ListSamplesRequest instance = (ListSamplesRequest) object;
        offset(instance.getOffset());
        addAllEntityValues(instance.getEntityValues());
        addAllEntityIds(instance.getEntityIds());
      }
      if (object instanceof AbstractApplicationScopedWitRequest) {
        AbstractApplicationScopedWitRequest instance = (AbstractApplicationScopedWitRequest) object;
        applicationId(instance.getApplicationId());
      }
    }

    /**
     * Initializes the value for the {@link ListSamplesRequest#getApplicationId() applicationId} attribute.
     * @param applicationId The value for applicationId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder applicationId(String applicationId) {
      this.applicationId = Objects.requireNonNull(applicationId, "applicationId");
      initBits &= ~INIT_BIT_APPLICATION_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link ListSamplesRequest#getOffset() offset} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link ListSamplesRequest#getOffset() offset}.</em>
     * @param offset The value for offset 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder offset(long offset) {
      this.offset = offset;
      optBits |= OPT_BIT_OFFSET;
      return this;
    }

    /**
     * Adds one element to {@link ListSamplesRequest#getEntityIds() entityIds} list.
     * @param element A entityIds element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityId(String element) {
      this.entityIds.add(Objects.requireNonNull(element, "entityIds element"));
      return this;
    }

    /**
     * Adds elements to {@link ListSamplesRequest#getEntityIds() entityIds} list.
     * @param elements An array of entityIds elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityIds(String... elements) {
      for (String element : elements) {
        this.entityIds.add(Objects.requireNonNull(element, "entityIds element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link ListSamplesRequest#getEntityIds() entityIds} list.
     * @param elements An iterable of entityIds elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityIds(Iterable<String> elements) {
      this.entityIds.clear();
      return addAllEntityIds(elements);
    }

    /**
     * Adds elements to {@link ListSamplesRequest#getEntityIds() entityIds} list.
     * @param elements An iterable of entityIds elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllEntityIds(Iterable<String> elements) {
      for (String element : elements) {
        this.entityIds.add(Objects.requireNonNull(element, "entityIds element"));
      }
      return this;
    }

    /**
     * Adds one element to {@link ListSamplesRequest#getEntityValues() entityValues} list.
     * @param element A entityValues element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityValue(String element) {
      this.entityValues.add(Objects.requireNonNull(element, "entityValues element"));
      return this;
    }

    /**
     * Adds elements to {@link ListSamplesRequest#getEntityValues() entityValues} list.
     * @param elements An array of entityValues elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityValues(String... elements) {
      for (String element : elements) {
        this.entityValues.add(Objects.requireNonNull(element, "entityValues element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link ListSamplesRequest#getEntityValues() entityValues} list.
     * @param elements An iterable of entityValues elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityValues(Iterable<String> elements) {
      this.entityValues.clear();
      return addAllEntityValues(elements);
    }

    /**
     * Adds elements to {@link ListSamplesRequest#getEntityValues() entityValues} list.
     * @param elements An iterable of entityValues elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllEntityValues(Iterable<String> elements) {
      for (String element : elements) {
        this.entityValues.add(Objects.requireNonNull(element, "entityValues element"));
      }
      return this;
    }

    /**
     * Builds a new {@link ImmutableListSamplesRequest ImmutableListSamplesRequest}.
     * @return An immutable instance of ListSamplesRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableListSamplesRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableListSamplesRequest(this);
    }

    private boolean offsetIsSet() {
      return (optBits & OPT_BIT_OFFSET) != 0;
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_APPLICATION_ID) != 0) attributes.add("applicationId");
      return "Cannot build ListSamplesRequest, some of required attributes are not set " + attributes;
    }
  }

  private static <T> List<T> createSafeList(Iterable<? extends T> iterable, boolean checkNulls, boolean skipNulls) {
    ArrayList<T> list;
    if (iterable instanceof Collection<?>) {
      int size = ((Collection<?>) iterable).size();
      if (size == 0) return Collections.emptyList();
      list = new ArrayList<>();
    } else {
      list = new ArrayList<>();
    }
    for (T element : iterable) {
      if (skipNulls && element == null) continue;
      if (checkNulls) Objects.requireNonNull(element, "element");
      list.add(element);
    }
    return list;
  }

  private static <T> List<T> createUnmodifiableList(boolean clone, List<T> list) {
    switch(list.size()) {
    case 0: return Collections.emptyList();
    case 1: return Collections.singletonList(list.get(0));
    default:
      if (clone) {
        return Collections.unmodifiableList(new ArrayList<>(list));
      } else {
        if (list instanceof ArrayList<?>) {
          ((ArrayList<?>) list).trimToSize();
        }
        return Collections.unmodifiableList(list);
      }
    }
  }
}
