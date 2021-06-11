# owoify-clj
Turning your worst nightmare into a Clojar.

[![Clojars Project](https://img.shields.io/clojars/v/net.clojars.deadshot465/owoify-clj.svg)](https://clojars.org/net.clojars.deadshot465/owoify-clj)
[![Clojure CI](https://github.com/deadshot465/owoify-clj/actions/workflows/clojure.yml/badge.svg)](https://github.com/deadshot465/owoify-clj/actions/workflows/clojure.yml)

This is a Clojure port of [mohan-cao's owoify-js](https://github.com/mohan-cao/owoify-js), which will help you turn any string into nonsensical babyspeak similar to LeafySweet's infamous Chrome extension.

Just like my other Owoify ports, three levels of owoness are available:

1. **owo (default)**: The most vanilla one.
2. **uwu**: The moderate one.
3. **uvu**: Litewawwy unweadabwal.

Please refer to the original [owoify-js repository](https://github.com/mohan-cao/owoify-js) for more information.

Of course there must be a Lispy owoify :)

## Reason for development

Because [Clojars.org](https://clojars.org/) doesn't have any owoify package yet and [Clojure](https://clojure.org/) is arguably one of the most popular Lisp languages.

## Installation

owoify-clj is available on [Clojars](https://clojure.org/). You can add owoify-clj to your dependency in `project.clj`:
```clojure
:dependencies [[net.clojars.deadshot465/owoify-clj "0.1.0"]]
```
Once [cljdoc](https://cljdoc.org) finishes generating the documentation, the documentation can be found at [https://cljdoc.org/d/net.clojars.deadshot465/owoify-clj/0.1.1/doc/readme](https://cljdoc.org/d/net.clojars.deadshot465/owoify-clj/0.1.1/doc/readme).

## Usage

```clojure
(ns my-awesome-project.core
  (:require [owoify-clj.core :refer :all]))

(def source "This is the string to owo! Kinda cute isn't it?")

(println (owoify-clj.core/owoify source "owo"))
(println (owoify-clj.core/owoify source "uvu"))
; Possible standard output:
; This is the stwing two owo! Kinda cute isn't it?
; fwis is the stwing twowo owowowoヽ(*・ω・)ﾉ Kinda cute isn't it?
```

## Disclaimer

As always, this package is written for practicing and bots' needs. Performance is **NOT** guaranteed.

That being said, PRs are always welcomed.

## See also

- [owoify-js](https://github.com/mohan-cao/owoify-js) - The original owoify-js repository.
- [Owoify.Net](https://www.nuget.org/packages/Owoify.Net/1.0.1) - The C# port of Owoify written by me.
- [Owoify++](https://github.com/deadshot465/OwoifyCpp) - The C++ header-only port of Owoify written by me.
- [owoify_rs](https://crates.io/crates/owoify_rs) - The Rust port of Owoify written by me.
- [owoify-py](https://pypi.org/project/owoify-py/) - The Python port of Owoify written by me.
- [owoify_dart](https://pub.dev/packages/owoify_dart) - The Dart port of Owoify written by me.
- [owoify_rb](https://rubygems.org/gems/owoify_rb) - The Ruby port of Owoify written by me.
- [owoify-go](https://github.com/deadshot465/owoify-go) - The Go port of Owoify written by me.
- [owoifySwift](https://github.com/deadshot465/OwoifySwift) - The Swift port of Owoify written by me.
- [owoifyKt](https://github.com/deadshot465/owoifyKt) - The Kotlin port of Owoify written by me.
- [owoify_ex](https://github.com/deadshot465/owoify_ex) - The Elixir port of Owoify written by me.
- [owoify_cr](https://github.com/deadshot465/owoify_cr) - The Crystal port of Owoify written by me.
- [owoifynim](https://github.com/deadshot465/owoifynim) - The Nim port of Owoify written by me.

## License

MIT License

Copyright (c) 2021 Chehui Chou

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
