package chattyer.nlp.wit.client.apps;

import chattyer.common.models.Language;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link PostApplicationRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePostApplicationRequest.builder()}.
 */
@Generated(from = "PostApplicationRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutablePostApplicationRequest extends PostApplicationRequest {
  private final String name;
  private final Language lang;
  private final boolean isPrivate;
  private final @Nullable String desc;

  private ImmutablePostApplicationRequest(ImmutablePostApplicationRequest.Builder builder) {
    this.name = builder.name;
    this.lang = builder.lang;
    this.isPrivate = builder.isPrivate;
    this.desc = builder.desc;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @JsonProperty("name")
  @Override
  public String getName() {
    return name;
  }

  /**
   * @return The value of the {@code lang} attribute
   */
  @JsonProperty("lang")
  @Override
  public Language getLang() {
    return lang;
  }

  /**
   * @return The value of the {@code isPrivate} attribute
   */
  @JsonProperty("private")
  @Override
  public boolean getIsPrivate() {
    return isPrivate;
  }

  /**
   * @return The value of the {@code desc} attribute
   */
  @JsonProperty("desc")
  @Override
  public @Nullable String getDesc() {
    return desc;
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePostApplicationRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@javax.annotation.Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePostApplicationRequest
        && equalTo((ImmutablePostApplicationRequest) another);
  }

  private boolean equalTo(ImmutablePostApplicationRequest another) {
    return name.equals(another.name)
        && lang.equals(another.lang)
        && isPrivate == another.isPrivate
        && Objects.equals(desc, another.desc);
  }

  /**
   * Computes a hash code from attributes: {@code name}, {@code lang}, {@code isPrivate}, {@code desc}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + lang.hashCode();
    h += (h << 5) + Boolean.hashCode(isPrivate);
    h += (h << 5) + Objects.hashCode(desc);
    return h;
  }

  /**
   * Prints the immutable value {@code PostApplicationRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "PostApplicationRequest{"
        + "name=" + name
        + ", lang=" + lang
        + ", isPrivate=" + isPrivate
        + ", desc=" + desc
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "PostApplicationRequest", generator = "Immutables")
  @Deprecated
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends PostApplicationRequest {
    @javax.annotation.Nullable String name;
    @javax.annotation.Nullable Language lang;
    boolean isPrivate;
    boolean isPrivateIsSet;
    @javax.annotation.Nullable String desc;
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @JsonProperty("lang")
    public void setLang(Language lang) {
      this.lang = lang;
    }
    @JsonProperty("private")
    public void setIsPrivate(boolean isPrivate) {
      this.isPrivate = isPrivate;
      this.isPrivateIsSet = true;
    }
    @JsonProperty("desc")
    public void setDesc(@Nullable String desc) {
      this.desc = desc;
    }
    @Override
    public String getName() { throw new UnsupportedOperationException(); }
    @Override
    public Language getLang() { throw new UnsupportedOperationException(); }
    @Override
    public boolean getIsPrivate() { throw new UnsupportedOperationException(); }
    @Override
    public String getDesc() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutablePostApplicationRequest fromJson(Json json) {
    ImmutablePostApplicationRequest.Builder builder = ImmutablePostApplicationRequest.builder();
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.lang != null) {
      builder.lang(json.lang);
    }
    if (json.isPrivateIsSet) {
      builder.isPrivate(json.isPrivate);
    }
    if (json.desc != null) {
      builder.desc(json.desc);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link ImmutablePostApplicationRequest ImmutablePostApplicationRequest}.
   * <pre>
   * ImmutablePostApplicationRequest.builder()
   *    .name(String) // required {@link PostApplicationRequest#getName() name}
   *    .lang(chattyer.common.models.Language) // required {@link PostApplicationRequest#getLang() lang}
   *    .isPrivate(boolean) // required {@link PostApplicationRequest#getIsPrivate() isPrivate}
   *    .desc(String | null) // nullable {@link PostApplicationRequest#getDesc() desc}
   *    .build();
   * </pre>
   * @return A new ImmutablePostApplicationRequest builder
   */
  public static ImmutablePostApplicationRequest.Builder builder() {
    return new ImmutablePostApplicationRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePostApplicationRequest ImmutablePostApplicationRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "PostApplicationRequest", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_LANG = 0x2L;
    private static final long INIT_BIT_IS_PRIVATE = 0x4L;
    private long initBits = 0x7L;

    private @javax.annotation.Nullable String name;
    private @javax.annotation.Nullable Language lang;
    private boolean isPrivate;
    private @javax.annotation.Nullable String desc;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code PostApplicationRequest} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(PostApplicationRequest instance) {
      Objects.requireNonNull(instance, "instance");
      name(instance.getName());
      lang(instance.getLang());
      isPrivate(instance.getIsPrivate());
      @Nullable String descValue = instance.getDesc();
      if (descValue != null) {
        desc(descValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link PostApplicationRequest#getName() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link PostApplicationRequest#getLang() lang} attribute.
     * @param lang The value for lang 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder lang(Language lang) {
      this.lang = Objects.requireNonNull(lang, "lang");
      initBits &= ~INIT_BIT_LANG;
      return this;
    }

    /**
     * Initializes the value for the {@link PostApplicationRequest#getIsPrivate() isPrivate} attribute.
     * @param isPrivate The value for isPrivate 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder isPrivate(boolean isPrivate) {
      this.isPrivate = isPrivate;
      initBits &= ~INIT_BIT_IS_PRIVATE;
      return this;
    }

    /**
     * Initializes the value for the {@link PostApplicationRequest#getDesc() desc} attribute.
     * @param desc The value for desc (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder desc(@Nullable String desc) {
      this.desc = desc;
      return this;
    }

    /**
     * Builds a new {@link ImmutablePostApplicationRequest ImmutablePostApplicationRequest}.
     * @return An immutable instance of PostApplicationRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePostApplicationRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePostApplicationRequest(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_LANG) != 0) attributes.add("lang");
      if ((initBits & INIT_BIT_IS_PRIVATE) != 0) attributes.add("isPrivate");
      return "Cannot build PostApplicationRequest, some of required attributes are not set " + attributes;
    }
  }
}
