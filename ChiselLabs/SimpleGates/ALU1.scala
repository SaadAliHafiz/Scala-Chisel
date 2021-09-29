package example
import chisel3._
import chisel3.util._



class ALU1 extends Module{
    val io= IO(new Bundle {
        val a=Input(SInt(8.W))
        val b=Input(SInt(8.W))
        val sel=Input(UInt(4.W))
        val out=Output(SInt(16.W))
    })

val Adr= io.a + io.b
val sub= io.a - io.b
val AndG= io.a & io.b
val ORG= io.a | io.b
val XORG=io.a ^ io.b
val s = io.b(4,0)//.asUInt
val LR_shft= io.a >> s
val L_shft= io.a << s
val AR_shft=io.a >> s
val EQU = io.a === io.b
val LST = io.a > io.b
val GRT = io.a < io.b

io.out:=MuxCase(0.S,Array (
    ( io.sel === 0.U) ->Adr,
    ( io.sel === 1.U) ->sub,
    ( io.sel === 2.U) ->AndG ,
    ( io.sel === 3.U) ->ORG ,
    ( io.sel === 4.U) ->XORG ,
    ( io.sel === 5.U) ->L_shft ,
    ( io.sel === 6.U) ->LR_shft ,
    ( io.sel === 7.U) ->AR_shft,
    ( io.sel === 8.U) ->Mux(EQU, 1.S, 0.S),
    ( io.sel === 9.U) ->Mux(LST, 1.S, 0.S),
    ( io.sel === 10.U) ->Mux(GRT, 1.S, 0.S),
    )
)
}