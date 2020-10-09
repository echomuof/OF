package gee

import (
	"log"
	"net/http"
)

type HandlerFunc func(w http.ResponseWriter, r *http.Request)

type Engine struct {
	router map[string]HandlerFunc
}

func New() *Engine {
	return &Engine{router: make(map[string]HandlerFunc)}
}

func (e Engine) addRouter(method string, url string, handler HandlerFunc) {
	e.router[method+"_"+url] = handler
}

func (e Engine) GET(url string, handler HandlerFunc) {
	e.addRouter("GET", url, handler)
}

func (e Engine) POST(url string, handler HandlerFunc) {
	e.addRouter("POST", url, handler)
}

func (e Engine) Run(addr string) error {
	return http.ListenAndServe(addr, e)
}

func (e Engine) ServeHTTP(w http.ResponseWriter, r *http.Request) {
	key := r.Method + "_" + r.URL.Path
	if handler, ok := e.router[key]; ok {
		handler(w, r)
		return
	}
	log.Fatalf("404 not found:%s\n", key)
}
