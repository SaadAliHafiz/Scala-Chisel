package example

import chisel3._


class Task02( counterBits : UInt ) extends Module {

    val io = IO (new Bundle {
    val result = Output ( Bool () )

    })

    val max = (1.U << counterBits ) - 1.U

    val count = RegInit (0.U (16. W) ) 

    when ( count(0.U) === 1.U ) {

        count := 0.U
        }
        
        .otherwise {
            count := count + 1.U
        }

io . result := count 

}
