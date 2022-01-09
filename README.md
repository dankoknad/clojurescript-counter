### "Simple Counter" is my very first web app written in clojure

It's not here to impress. Just to get my hands dirty and learn something new.

Tools used:
- [Leiningen](https://leiningen.org/)
- [Reagent](https://github.com/reagent-project/reagent)
- [reagent-material-ui](https://github.com/arttuka/reagent-material-ui)

Screenshots:

<img src="https://github.com/dankoknad/clojurescript-counter/blob/master/public/img/01.jpg" width="425">
<img src="https://github.com/dankoknad/clojurescript-counter/blob/master/public/img/02.jpg" width="425">
<img src="https://github.com/dankoknad/clojurescript-counter/blob/master/public/img/03.jpg" width="425">

### Development mode
```
npm install
npx shadow-cljs watch app
```
start a ClojureScript REPL
```
npx shadow-cljs browser-repl
```
### Building for production

```
npx shadow-cljs release app
```
