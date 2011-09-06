package test.code;

import groovy.util.GroovyTestCase;

class TestExpandorUsingGroovyTestCase extends GroovyTestCase {
	
	def relay(request, farm) {
		farm.machines.sort { it.load }[0].send(request)
	}
	
	void testExpandor(){
		def fakeOne = new Expando(load:10,send:{false})
		def fakeTwo = new Expando(load:5,send:{true})
		def farm = [machines: [fakeOne,fakeTwo]]
		assert relay(null, farm)
	}

}
