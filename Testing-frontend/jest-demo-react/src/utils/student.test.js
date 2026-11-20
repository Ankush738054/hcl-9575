import {isEligible} from "./student.js"
import { describe, test, expect } from '@jest/globals'

describe("student Attendence Testing",()=>{
    test('Attendence Should have>75%',()=>{
        expect(isEligible(79)).toBe(true);
    })
    test('Attendence Should have<75%',()=>{
        expect(isEligible(47)).toBe(false);
    })
    test('Invalid Attendence',()=>{
        expect(() => isEligible(104)).toThrow("Invalid Attendence Value");
        expect(() => isEligible(-10)).toThrow("Invalid Attendence Value");
    })
})