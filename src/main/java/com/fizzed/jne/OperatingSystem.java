package com.fizzed.jne;

/*-
 * #%L
 * jne
 * %%
 * Copyright (C) 2016 - 2017 Fizzed, Inc
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

/**
 * Operating system that Java is running on.
 */
public enum OperatingSystem {

    WINDOWS("Windows", null),
    MACOS("MacOS", new String[] { "osx" }),
    LINUX("Linux", null),
    FREEBSD("FreeBSD", null),
    OPENBSD("OpenBSD", null),
    SOLARIS("Solaris", null);

    private final String descriptor;
    private final String[] aliases;

    OperatingSystem(String descriptor, String[] aliases) {
        this.descriptor = descriptor;
        this.aliases = aliases;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public String[] getAliases() {
        return aliases;
    }

    static public OperatingSystem resolve(String value) {
        for (OperatingSystem os : OperatingSystem.values()) {
            if (os.name().equalsIgnoreCase(value)) {
                return os;
            }
            if (os.getAliases() != null) {
                for (String alias : os.getAliases()) {
                    if (alias.equalsIgnoreCase(value)) {
                        return os;
                    }
                }
            }
        }
        return null;
    }

}