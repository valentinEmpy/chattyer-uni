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
 * Immutable implementation of {@link DeleteSampleRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableDeleteSampleRequest.builder()}.
 */
@Generated(from = "DeleteSampleRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableDeleteSampleRequest extends DeleteSampleRequest {
  private final String applicationId;
  private final List<String> texts;

  private ImmutableDeleteSampleRequest(ImmutableDeleteSampleRequest.Builder builder) {
    this.applicationId = builder.applicationId;
    this.texts = createUnmodifiableList(true, builder.texts);
  }

  /**
   * @return The value of the {@code applicationId} attribute
   */
  @Override
  public String getApplicationId() {
    return applicationId;
  }

  /**
   * @return The value of the {@code texts} attribute
   */
  @Override
  public List<String> getTexts() {
    return texts;
  }

  /**
   * This instance is equal to all instances of {@code ImmutableDeleteSampleRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableDeleteSampleRequest
        && equalTo((ImmutableDeleteSampleRequest) another);
  }

  private boolean equalTo(ImmutableDeleteSampleRequest another) {
    return applicationId.equals(another.applicationId)
        && texts.equals(another.texts);
  }

  /**
   * Computes a hash code from attributes: {@code applicationId}, {@code texts}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + applicationId.hashCode();
    h += (h << 5) + texts.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code DeleteSampleRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "DeleteSampleRequest{"
        + "applicationId=" + applicationId
        + ", texts=" + texts
        + "}";
  }

  /**
   * Creates a builder for {@link ImmutableDeleteSampleRequest ImmutableDeleteSampleRequest}.
   * <pre>
   * ImmutableDeleteSampleRequest.builder()
   *    .applicationId(String) // required {@link DeleteSampleRequest#getApplicationId() applicationId}
   *    .text|addAllTexts(String) // {@link DeleteSampleRequest#getTexts() texts} elements
   *    .build();
   * </pre>
   * @return A new ImmutableDeleteSampleRequest builder
   */
  public static ImmutableDeleteSampleRequest.Builder builder() {
    return new ImmutableDeleteSampleRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableDeleteSampleRequest ImmutableDeleteSampleRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "DeleteSampleRequest", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_APPLICATION_ID = 0x1L;
    private long initBits = 0x1L;

    private @Nullable String applicationId;
    private List<String> texts = new ArrayList<String>();

    private Builder() {
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

    /**
     * Fill a builder with attribute values from the provided {@code chattyer.nlp.wit.client.samples.DeleteSampleRequest} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(DeleteSampleRequest instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    private void from(Object object) {
      if (object instanceof AbstractApplicationScopedWitRequest) {
        AbstractApplicationScopedWitRequest instance = (AbstractApplicationScopedWitRequest) object;
        applicationId(instance.getApplicationId());
      }
      if (object instanceof DeleteSampleRequest) {
        DeleteSampleRequest instance = (DeleteSampleRequest) object;
        addAllTexts(instance.getTexts());
      }
    }

    /**
     * Initializes the value for the {@link DeleteSampleRequest#getApplicationId() applicationId} attribute.
     * @param applicationId The value for applicationId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder applicationId(String applicationId) {
      this.applicationId = Objects.requireNonNull(applicationId, "applicationId");
      initBits &= ~INIT_BIT_APPLICATION_ID;
      return this;
    }

    /**
     * Adds one element to {@link DeleteSampleRequest#getTexts() texts} list.
     * @param element A texts element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder text(String element) {
      this.texts.add(Objects.requireNonNull(element, "texts element"));
      return this;
    }

    /**
     * Adds elements to {@link DeleteSampleRequest#getTexts() texts} list.
     * @param elements An array of texts elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder texts(String... elements) {
      for (String element : elements) {
        this.texts.add(Objects.requireNonNull(element, "texts element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link DeleteSampleRequest#getTexts() texts} list.
     * @param elements An iterable of texts elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder texts(Iterable<String> elements) {
      this.texts.clear();
      return addAllTexts(elements);
    }

    /**
     * Adds elements to {@link DeleteSampleRequest#getTexts() texts} list.
     * @param elements An iterable of texts elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllTexts(Iterable<String> elements) {
      for (String element : elements) {
        this.texts.add(Objects.requireNonNull(element, "texts element"));
      }
      return this;
    }

    /**
     * Builds a new {@link ImmutableDeleteSampleRequest ImmutableDeleteSampleRequest}.
     * @return An immutable instance of DeleteSampleRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableDeleteSampleRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableDeleteSampleRequest(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_APPLICATION_ID) != 0) attributes.add("applicationId");
      return "Cannot build DeleteSampleRequest, some of required attributes are not set " + attributes;
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
