package chattyer.nlp.wit.client.samples;

import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import chattyer.nlp.wit.models.Sample;
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
 * Immutable implementation of {@link PostSampleRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePostSampleRequest.builder()}.
 */
@Generated(from = "PostSampleRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutablePostSampleRequest extends PostSampleRequest {
  private final String applicationId;
  private final List<Sample> samples;

  private ImmutablePostSampleRequest(ImmutablePostSampleRequest.Builder builder) {
    this.applicationId = builder.applicationId;
    this.samples = createUnmodifiableList(true, builder.samples);
  }

  /**
   * @return The value of the {@code applicationId} attribute
   */
  @Override
  public String getApplicationId() {
    return applicationId;
  }

  /**
   * @return The value of the {@code samples} attribute
   */
  @Override
  public List<Sample> getSamples() {
    return samples;
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePostSampleRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePostSampleRequest
        && equalTo((ImmutablePostSampleRequest) another);
  }

  private boolean equalTo(ImmutablePostSampleRequest another) {
    return applicationId.equals(another.applicationId)
        && samples.equals(another.samples);
  }

  /**
   * Computes a hash code from attributes: {@code applicationId}, {@code samples}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + applicationId.hashCode();
    h += (h << 5) + samples.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code PostSampleRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "PostSampleRequest{"
        + "applicationId=" + applicationId
        + ", samples=" + samples
        + "}";
  }

  /**
   * Creates a builder for {@link ImmutablePostSampleRequest ImmutablePostSampleRequest}.
   * <pre>
   * ImmutablePostSampleRequest.builder()
   *    .applicationId(String) // required {@link PostSampleRequest#getApplicationId() applicationId}
   *    .sample|addAllSamples(chattyer.nlp.wit.models.Sample) // {@link PostSampleRequest#getSamples() samples} elements
   *    .build();
   * </pre>
   * @return A new ImmutablePostSampleRequest builder
   */
  public static ImmutablePostSampleRequest.Builder builder() {
    return new ImmutablePostSampleRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePostSampleRequest ImmutablePostSampleRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "PostSampleRequest", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_APPLICATION_ID = 0x1L;
    private long initBits = 0x1L;

    private @Nullable String applicationId;
    private List<Sample> samples = new ArrayList<Sample>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code chattyer.nlp.wit.client.samples.PostSampleRequest} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(PostSampleRequest instance) {
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
      if (object instanceof PostSampleRequest) {
        PostSampleRequest instance = (PostSampleRequest) object;
        addAllSamples(instance.getSamples());
      }
      if (object instanceof AbstractApplicationScopedWitRequest) {
        AbstractApplicationScopedWitRequest instance = (AbstractApplicationScopedWitRequest) object;
        applicationId(instance.getApplicationId());
      }
    }

    /**
     * Initializes the value for the {@link PostSampleRequest#getApplicationId() applicationId} attribute.
     * @param applicationId The value for applicationId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder applicationId(String applicationId) {
      this.applicationId = Objects.requireNonNull(applicationId, "applicationId");
      initBits &= ~INIT_BIT_APPLICATION_ID;
      return this;
    }

    /**
     * Adds one element to {@link PostSampleRequest#getSamples() samples} list.
     * @param element A samples element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder sample(Sample element) {
      this.samples.add(Objects.requireNonNull(element, "samples element"));
      return this;
    }

    /**
     * Adds elements to {@link PostSampleRequest#getSamples() samples} list.
     * @param elements An array of samples elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder samples(Sample... elements) {
      for (Sample element : elements) {
        this.samples.add(Objects.requireNonNull(element, "samples element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link PostSampleRequest#getSamples() samples} list.
     * @param elements An iterable of samples elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder samples(Iterable<? extends Sample> elements) {
      this.samples.clear();
      return addAllSamples(elements);
    }

    /**
     * Adds elements to {@link PostSampleRequest#getSamples() samples} list.
     * @param elements An iterable of samples elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllSamples(Iterable<? extends Sample> elements) {
      for (Sample element : elements) {
        this.samples.add(Objects.requireNonNull(element, "samples element"));
      }
      return this;
    }

    /**
     * Builds a new {@link ImmutablePostSampleRequest ImmutablePostSampleRequest}.
     * @return An immutable instance of PostSampleRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePostSampleRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePostSampleRequest(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_APPLICATION_ID) != 0) attributes.add("applicationId");
      return "Cannot build PostSampleRequest, some of required attributes are not set " + attributes;
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
