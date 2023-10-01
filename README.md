# **HTML**

*How create a new HTML Document?*

## Usage

```java

final HtmlBuilder htmlBuilder = new HtmlBuilder();

// Header configuration
htmlBuilder.title("Demo HTML Document");
htmlBuilder.charset(StandardCharsets.UTF_8);
htmlBuilder.metadata("viewport", "width=device-width, initial-scale=1");
htmlBuilder.metadata("keywords", "HTML, demo");

// Body configuration
final HtmlTag aboutTitle = new HtmlTagBuilder(Tag.H1)
        .className("title")
        .innerHtml("About Us")
        .build();

final HtmlTag contactTitle = new HtmlTagBuilder(Tag.H1)
        .className("title")
        .innerHtml("Contact Us")
        .build();

final HtmlTag aboutSection = new HtmlTagBuilder(Tag.SECTION)
        .id("about")
        .child(aboutTitle)
        .build();

final HtmlTag contactSection = new HtmlTagBuilder(Tag.SECTION)
        .id("contact")
        .child(contactTitle)
        .build();

final HtmlTag main = new HtmlTagBuilder(Tag.MAIN)
        .child(aboutSection)
        .child(contactSection)
        .build();

htmlBuilder.node(main);

final Html document = htmlBuilder.build();
```