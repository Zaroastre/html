package io.nirahtech.librairies.html;

import java.util.Collection;
import java.util.Optional;

interface Root {
    Optional<HTMLTag> getElementById(final String id);
    Collection<HTMLTag> getElementsByTagName(final Tag tag);
    Collection<HTMLTag> getElementsByClassName(final String className);
    Collection<HTMLTag> getElementsByName(final String name);
}
