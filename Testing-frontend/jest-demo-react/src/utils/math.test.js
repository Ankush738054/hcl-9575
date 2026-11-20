import { describe, test, expect } from '@jest/globals'
import { add, subtract, multiply } from './math.js'

describe("Math Utility Testing", ()=>{
    test('should add two numbers',()=>{
        expect(add(10,20)).toBe(30);
    })
    test('should subtract numbers',()=>{
        expect(subtract(20,10)).toBe(10);
    })
    test('should multiply numbers',()=>{
        expect(multiply(20,10)).toBe(200);
    })
})
