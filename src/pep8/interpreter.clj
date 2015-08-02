(ns pep8.interpreter)

(def default-os
  (list 16rC8 16r00 16r00 16rE9 16rFC 16r4F 16r49 16rFC 16r50 16rC1
        16rFC 16r4F 16rB0 16r00 16r7A 16r0A 16rFC 16r9A 16rB0 16r00
        16r39 16r06 16rFC 16r72 16r70 16r00 16r09 16r1C 16r1C 16r1C
        16r1C 16rF1 16rFC 16r52 16r49 16rFC 16r50 16rC1 16rFC 16r4F
        16rB0 16r00 16r39 16r06 16rFC 16r88 16r70 16r00 16r09 16r90
        16r00 16r0F 16rA1 16rFC 16r51 16rF5 16r00 16r00 16r78 16r00
        16r01 16r49 16rFC 16r50 16r04 16rFC 16r5D 16r00 16rC8 16r00
        16r00 16rDB 16r00 16r09 16rB8 16r00 16r28 16r0E 16rFC 16rB7
        16r98 16r00 16r03 16r1D 16r17 16rFC 16rAF 16r01 16rFD 16rB6
        16rFD 16rB7 16rFD 16rB8 16rFD 16rB9 16r1F 16r1F 16r1F 16r88
        16r00 16r05 16r1D 16r17 16rFC 16rC2 16r01 16rFD 16rBA 16rFD
        16rC4 16rFF 16r3B 16rFF 16rC6 16rC0 16r00 16r01 16rDB 16r00
        16r0D 16r98 16r00 16r07 16r0A 16rFC 16rDD 16r1C 16r88 16r00
        16r01 16r0C 16rFC 16rD6 16r91 16rFC 16r53 16r0A 16rFC 16rE4
        16r58 16r50 16r00 16r0A 16rC0 16rFC 16rF4 16rE3 16rFF 16rFE
        16r68 16r00 16r02 16r16 16rFF 16rE2 16r00 16r45 16r52 16r52
        16r4F 16r52 16r3A 16r20 16r49 16r6E 16r76 16r61 16r6C 16r69
        16r64 16r20 16r74 16r72 16r61 16r70 16r20 16r61 16r64 16r64
        16r72 16r65 16r73 16r73 16r69 16r6E 16r67 16r20 16r6D 16r6F
        16r64 16r65 16r2E 16r00 16rDB 16r00 16r0D 16r98 16r00 16r07
        16r1D 16r05 16rFD 16r23 16rFD 16r33 16rFD 16r3D 16rFD 16r4A
        16rFD 16r5A 16rFD 16r6A 16rFD 16r7D 16rFD 16r8D 16rFD 16rA0
        16rCB 16r00 16r09 16r88 16r00 16r02 16rE9 16rFC 16r55 16r58
        16rCB 16r00 16r09 16r88 16r00 16r02 16rCD 16r00 16r00 16rE9
        16rFC 16r55 16r58 16rCB 16r00 16r09 16r88 16r00 16r02 16rCD
        16r00 16r00 16rCD 16r00 16r00 16rE9 16rFC 16r55 16r58 16rCB
        16r00 16r09 16r88 16r00 16r02 16rCD 16r00 16r00 16r7B 16r00
        16r0B 16rE9 16rFC 16r55 16r58 16rCB 16r00 16r09 16r88 16r00
        16r02 16rCD 16r00 16r00 16r7B 16r00 16r0B 16rCD 16r00 16r00
        16rE9 16rFC 16r55 16r58 16rCB 16r00 16r09 16r88 16r00 16r02
        16rCD 16r00 16r00 16r7B 16r00 16r07 16rE9 16rFC 16r55 16r58
        16rCB 16r00 16r09 16r88 16r00 16r02 16rCD 16r00 16r00 16r7B
        16r00 16r07 16r7B 16r00 16r0B 16rE9 16rFC 16r55 16r58 16rCB
        16r00 16r09 16r88 16r00 16r02 16rCD 16r00 16r00 16r7B 16r00
        16r0B 16rCD 16r00 16r00 16r7B 16r00 16r07 16rE9 16rFC 16r55
        16r58 16r58 16r58 16r58 16r58 16rC0 16r00 16r01 16rE1 16rFC
        16r53 16r16 16rFC 16rCA 16r58 16rC0 16r00 16rFE 16rE1 16rFC
        16r53 16r16 16rFC 16rCA 16r16 16rFD 16r19 16r68 16r00 16r0C
        16rC0 16r00 16r00 16rE3 16r00 16r06 16rC0 16r00 16r00 16rE3
        16r00 16r02 16rC0 16r00 16r00 16rE1 16rFC 16r4F 16r49 16rFC
        16r50 16rC1 16rFC 16r4F 16r90 16r00 16r0F 16rE3 16r00 16r08
        16rC1 16rFC 16r4F 16rCB 16r00 16r02 16r1D 16r05 16rFD 16rFB
        16rFE 16r01 16rFE 16r5B 16rFE 16r76 16rB0 16r00 16r2B 16r0C
        16rFE 16r16 16rC8 16r00 16r00 16rEB 16r00 16r04 16rC8 16r00
        16r01 16rEB 16r00 16r02 16r04 16rFD 16rE5 16rB0 16r00 16r2D
        16r0C 16rFE 16r2B 16rC8 16r00 16r01 16rEB 16r00 16r04 16rC8
        16r00 16r01 16rEB 16r00 16r02 16r04 16rFD 16rE5 16rB0 16r00
        16r30 16r08 16rFE 16r4C 16rB0 16r00 16r39 16r10 16rFE 16r4C
        16rC8 16r00 16r00 16rEB 16r00 16r04 16rCB 16r00 16r08 16rEB
        16r00 16r0A 16rC8 16r00 16r02 16rEB 16r00 16r02 16r04 16rFD
        16rE5 16rB0 16r00 16r20 16r0A 16rFD 16rE5 16rB0 16r00 16r0A
        16r0C 16rFF 16r11 16r04 16rFD 16rE5 16rB0 16r00 16r30 16r08
        16rFF 16r11 16rB0 16r00 16r39 16r10 16rFF 16r11 16rCB 16r00
        16r08 16rEB 16r00 16r0A 16rC8 16r00 16r02 16rEB 16r00 16r02
        16r04 16rFD 16rE5 16rB0 16r00 16r30 16r08 16rFE 16rC7 16rB0
        16r00 16r39 16r10 16rFE 16rC7 16rC8 16r00 16r01 16rC3 16r00
        16r0A 16r1C 16r12 16rFE 16r8F 16r04 16rFE 16r92 16rEB 16r00
        16r06 16rE3 16r00 16r00 16r1C 16r12 16rFE 16r9C 16r04 16rFE
        16r9F 16rEB 16r00 16r06 16r1C 16r12 16rFE 16rA6 16r04 16rFE
        16rA9 16rEB 16r00 16r06 16r73 16r00 16r00 16r12 16rFE 16rB2
        16r04 16rFE 16rB5 16rEB 16r00 16r06 16r73 16r00 16r08 16r12
        16rFE 16rBE 16r04 16rFE 16rC1 16rEB 16r00 16r06 16rE3 16r00
        16r0A 16r04 16rFD 16rE5 16rC3 16r00 16r04 16r0A 16rFE 16rE3
        16rC3 16r00 16r0A 16rB0 16r80 16r00 16r0A 16rFE 16rDD 16r1A
        16rE3 16r00 16r0A 16r04 16rFE 16rE3 16rC0 16r00 16r00 16rE3
        16r00 16r06 16rDB 16r00 16r0E 16r98 16r00 16r01 16rC3 16r00
        16r0A 16r0E 16rFE 16rF2 16rA8 16r00 16r08 16rB0 16r00 16r00
        16r0C 16rFE 16rFB 16rA8 16r00 16r04 16rC3 16r00 16r06 16r0A
        16rFF 16r04 16rA8 16r00 16r02 16rFB 16r00 16r0E 16rC3 16r00
        16r0A 16rE2 16rFC 16r55 16r60 16r00 16r0C 16r58 16r50 16r00
        16r0A 16rC0 16rFF 16r21 16rE3 16rFF 16rFE 16r68 16r00 16r02
        16r16 16rFF 16rE2 16r00 16r45 16r52 16r52 16r4F 16r52 16r3A
        16r20 16r49 16r6E 16r76 16r61 16r6C 16r69 16r64 16r20 16r44
        16r45 16r43 16r49 16r20 16r69 16r6E 16r70 16r75 16r74 16r00
        16rC0 16r00 16rFF 16rE1 16rFC 16r53 16r16 16rFC 16rCA 16r16
        16rFD 16r19 16r68 16r00 16r06 16rC2 16rFC 16r55 16rB0 16r00
        16r00 16r0E 16rFF 16r57 16r50 16r00 16r2D 16r1A 16rE3 16r00
        16r00 16rC0 16r00 16r00 16rE3 16r00 16r02 16rC0 16r27 16r10
        16rE3 16r00 16r04 16r16 16rFF 16r91 16rC0 16r03 16rE8 16rE3
        16r00 16r04 16r16 16rFF 16r91 16rC0 16r00 16r64 16rE3 16r00
        16r04 16r16 16rFF 16r91 16rC0 16r00 16r0A 16rE3 16r00 16r04
        16r16 16rFF 16r91 16rC3 16r00 16r00 16rA0 16r00 16r30 16rF1
        16rFC 16r50 16r51 16rFC 16r50 16r5E 16rC3 16r00 16r02 16rC8
        16r00 16r00 16r83 16r00 16r06 16r08 16rFF 16rA6 16r78 16r00
        16r01 16rE3 16r00 16r02 16r04 16rFF 16r97 16rB8 16r00 16r00
        16r0A 16rFF 16rB5 16rC0 16r00 16r01 16rE3 16r00 16r04 16r04
        16rFF 16rBC 16rC3 16r00 16r04 16r0C 16rFF 16rBC 16r58 16rA8
        16r00 16r30 16rE9 16rFC 16r4F 16r51 16rFC 16r50 16r58 16rC0
        16r00 16r16 16rE1 16rFC 16r53 16r16 16rFC 16rCA 16r16 16rFD
        16r19 16rC1 16rFC 16r55 16rE3 16rFF 16rFE 16r68 16r00 16r02
        16r16 16rFF 16rE2 16r60 16r00 16r02 16r58 16rC8 16r00 16r00
        16rC0 16r00 16r00 16rD7 16r00 16r02 16r0A 16rFF 16rF7 16r57
        16r00 16r02 16r78 16r00 16r01 16r04 16rFF 16rE8 16r58 16rFB
        16rCF 16rFC 16r4F 16rFC 16r57 16rFC 16r9B))

;Utils
(defn get-empty-memory
  []
  (repeat 65536 0))

(defn make-state
  [a x sp pc is os n z v c memory start-rom-address running]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn read-byte
  [memory addr]
  (nth memory (bit-and addr 16rffff)))

(defn read-word
  [memory addr]
  (+ (* 256 (nth memory (bit-and addr 16rffff))) (nth memory (bit-and (inc addr) 16rffff))))

(defmulti read-byte-operand
          (fn [memory addr-mode] addr-mode))

(defmethod read-byte-operand :i [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode]
  os)

(defmethod read-byte-operand :d [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode]
  (read-byte memory os))

(defmethod read-byte-operand :n [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode]
  (read-byte memory (read-word memory os)))

(defmethod read-byte-operand :s [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode]
  (read-byte memory (+ sp os)))

(defmethod read-byte-operand :sf [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode]
  (read-byte memory (read-word memory (+ sp os))))

(defmethod read-byte-operand :x [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode]
  (read-byte memory (+ os x)))

(defmethod read-byte-operand :sx [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode]
  (read-byte memory (+ sp os x)))

(defmethod read-byte-operand :sxf [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode]
  (read-byte memory (+ x (read-word memory (+ sp os)))))

(defmulti read-word-operand
          (fn [memory addr-mode] addr-mode))

(defmethod read-word-operand :i [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode]
  os)

(defmethod read-word-operand :d [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode]
  (read-word memory os))

(defmethod read-word-operand :n [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode]
  (read-word memory (read-word memory os)))

(defmethod read-word-operand :s [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode]
  (read-word memory (+ sp os)))

(defmethod read-word-operand :sf [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode]
  (read-word memory (read-word memory (+ sp os))))

(defmethod read-word-operand :x [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode]
  (read-word memory (+ os x)))

(defmethod read-word-operand :sx [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode]
  (read-word memory (+ sp os x)))

(defmethod read-word-operand :sxf [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode]
  (read-word memory (+ x (read-word memory (+ sp os)))))

(defn write-byte
  [[a x sp pc is os n z v c memory start-rom-address running :as state] addr value]
  (if (< addr start-rom-address)
    [a x sp pc is os n z v c (assoc memory (bit-and addr 16rffff) value) running]))

(defn write-word
  [[a x sp pc is os n z v c memory start-rom-address running :as state] addr value]
  (if (< addr start-rom-address) ; Intentional innacuracy (it is possiblo to overwrite the first byte of ROM).
    (let [addr (bit-and addr 16rffff)
          memory (assoc memory addr (int (/ value 256)))
          addr (bit-and (inc addr) 16rffff)
          memory (assoc memory addr (int (mod value 256)))]
      [a x sp pc is os n z v c memory start-rom-address running])))

(defmulti write-byte-operand
          (fn [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode value] addr-mode))

(defmethod write-byte-operand :d [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode value]
  (write-byte state os value))

(defmethod write-byte-operand :n [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode value]
  (write-byte state (read-word memory os) value))

(defmethod write-byte-operand :s [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode value]
  (write-byte state (+ sp os) value))

(defmethod write-byte-operand :sf [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode value]
  (write-byte state (read-word memory (+ sp os)) value))

(defmethod write-byte-operand :x [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode value]
  (write-byte state (+ os x) value))

(defmethod write-byte-operand :sx [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode value]
  (write-byte state (+ sp os x) value))

(defmethod write-byte-operand :sxf [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode value]
  (write-byte state (+ x (read-word memory (+ sp os))) value))

(defmulti write-word-operand
          (fn [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode value] addr-mode))

(defmethod write-word-operand :d [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode value]
  (write-word state os value))

(defmethod write-word-operand :n [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode value]
  (write-word state (read-word memory os) value))

(defmethod write-word-operand :s [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode value]
  (write-word state (+ sp os) value))

(defmethod write-word-operand :sf [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode value]
  (write-word state (read-word memory (+ sp os)) value))

(defmethod write-word-operand :x [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode value]
  (write-word state (+ os x) value))

(defmethod write-word-operand :sx [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode value]
  (write-word state (+ sp os x) value))

(defmethod write-word-operand :sxf [[a x sp pc is os n z v c memory start-rom-address running :as state] addr-mode value]
  (write-word state (+ x (read-word memory (+ sp os))) value))

(defn replace-memory-block [memory new-value start-addr]
  (let [new-value-len (count new-value)
        memory-before (take start-addr memory)
        memory-after-len (- (count memory) start-addr new-value-len)
        memory-after (take-last memory-after-len memory)]
    (concat memory-before new-value memory-after)))

(defn load-os [memory os]
  (let [os-length (count os)
        memory-length (count memory)
        start-rom-address (- memory-length os-length)
        memory (replace-memory-block memory os start-rom-address)]
    [memory start-rom-address]))

(defn load-program [memory program]
  (replace-memory-block memory program 0))

(defn get-addressing-mode
  [[a x sp pc is os n z v c memory start-rom-address running :as state] addressing-specifier]
  (case addressing-specifier
    :a (case (bit-and is 1)
         0 :i
         1 :x)
    :aaa (case (bit-and is 2r111)
           0 :i
           1 :d
           2 :n
           3 :s
           4 :sf
           5 :x
           6 :sx
           7 :sxf)))

(defn get-register
  [[a x sp pc is os n z v c memory start-rom-address running :as state] register-specifier]
  (let [register-val (case register-specifier
                       :r (bit-and is 1)
                       :raaa (bit-and is 2r1000))]
    (if (= 0 register-val)
      :a
      :x)))

(defn get-value-from-inst
  [[a x sp pc is os n z v c memory start-rom-address running :as state] value-specifier]
  (case value-specifier
    :nn (bit-and is 2r11)
    :nnn (bit-and is 2r111)))

;Functions implementation
(defn stop
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address false])

(defn rettr
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  (let [temp (read-byte memory sp)
        n (not= 0 (bit-and temp 8))
        z (not= 0 (bit-and temp 4))
        v (not= 0 (bit-and temp 2))
        c (not= 0 (bit-and temp 1))
        a (read-word memory (inc sp))
        x (read-word memory (+ sp 3))
        pc (read-word memory (+ sp 5))
        sp (read-word memory (+ sp 7))]
    [a x sp pc is os n z v c memory start-rom-address running]))

(defn movspa
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [sp x sp pc is os n z v c memory start-rom-address running])

(defn movflga
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [(bit-or (if c 1
                 0)
           (if v 2
                 0)
           (if z 4
                 0)
           (if n 8
                 0)) x sp pc is os n z v c memory start-rom-address running])

(defn br
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  (let [addr-mode (get-addressing-mode state :a)
        os (read-word-operand memory addr-mode)
        pc os]
    [a x sp pc is os n z v c memory start-rom-address running]))

(defn brle
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  (let [addr-mode (get-addressing-mode state :a)
        os (read-word-operand memory addr-mode)
        pc (if (or n z) os
                        pc)]
    [a x sp pc is os n z v c memory start-rom-address running]))

(defn brlt
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  (let [addr-mode (get-addressing-mode state :a)
        os (read-word-operand memory addr-mode)
        pc (if n os
                 pc)]
    [a x sp pc is os n z v c memory start-rom-address running]))

(defn breq
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  (let [addr-mode (get-addressing-mode state :a)
        os (read-word-operand memory addr-mode)
        pc (if z os
                 pc)]
    [a x sp pc is os n z v c memory start-rom-address running]))

(defn brne
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  (let [addr-mode (get-addressing-mode state :a)
        os (read-word-operand memory addr-mode)
        pc (if (not z) os
                       pc)]
    [a x sp pc is os n z v c memory start-rom-address running]))

(defn brge
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  (let [addr-mode (get-addressing-mode state :a)
        os (read-word-operand memory addr-mode)
        pc (if (not n) os
                       pc)]
    [a x sp pc is os n z v c memory start-rom-address running]))

(defn brgt
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  (let [addr-mode (get-addressing-mode state :a)
        os (read-word-operand memory addr-mode)
        pc (if (or (not n) (not z)) os
                                    pc)]
    [a x sp pc is os n z v c memory start-rom-address running]))

(defn brv
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  (let [addr-mode (get-addressing-mode state :a)
        os (read-word-operand memory addr-mode)
        pc (if v os
                 pc)]
    [a x sp pc is os n z v c memory start-rom-address running]))

(defn brc
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  (let [addr-mode (get-addressing-mode state :a)
        os (read-word-operand memory addr-mode)
        pc (if c os
                 pc)]
    [a x sp pc is os n z v c memory start-rom-address running]))

(defn call
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn notr
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn negr
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn aslr
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn asrr
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn rolr
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn rorr
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn nopn
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn nop
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn deci
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn deco
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn stro
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn chari
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn charo
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn retn
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn addsp
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn subsp
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn addr
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn subr
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn andr
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn orr
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn cpr
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn ldr
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn ldbyter
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn str-
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

(defn stbyter
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  [a x sp pc is os n z v c memory start-rom-address running])

; List of function
; The position in the array represent its numerical value
; Each function is able to represent its variance
(def inst-to-fn
  (flatten [stop rettr movspa movflga br br brle brle brlt brlt breq
            breq brne brne brge brge brgt brgt brv brv brc brc call
            call notr notr negr negr aslr aslr asrr asrr rolr rolr rorr
            rorr (repeat 4 nopn) (repeat 8 nop) (repeat 8 deci)
            (repeat 8 deco) (repeat 8 stro) (repeat 8 chari)
            (repeat 8 charo) (repeat 8 retn) (repeat 8 addsp)
            (repeat 8 subsp) (repeat 16 addr) (repeat 16 subr)
            (repeat 16 andr) (repeat 16 orr) (repeat 16 cpr)
            (repeat 16 ldr) (repeat 16 ldbyter) (repeat 16 str-)
            (repeat 16 stbyter)]))

; List if function is unary
; The position in the array represent its numerical value
(def is-unary-inst
  (flatten [true true true true false false false false false false false
            false false false false false false false false false false false false
            false true true true true true true true true true true true
            true (repeat 4 true) (repeat 8 false) (repeat 8 false)
            (repeat 8 false) (repeat 8 false) (repeat 8 false)
            (repeat 8 false) (repeat 8 true) (repeat 8 false)
            (repeat 8 false) (repeat 16 false) (repeat 16 false)
            (repeat 16 false) (repeat 16 false) (repeat 16 false)
            (repeat 16 false) (repeat 16 false) (repeat 16 false)
            (repeat 16 false)]))

; Von Neumann Machine step

(defn von-neumann-machine-step
  [[a x sp pc is os n z v c memory start-rom-address running :as state]]
  (let [is (read-byte memory pc) ; Fetch instruction
        pc (inc pc) ; Increment program counter
        func (nth inst-to-fn is) ; Decode
        os (if (nth is-unary-inst is)
             os
             os)
        pc (if (nth is-unary-inst is)
             pc
             (+ 2 pc))]
    (func (make-state a x sp pc is os n z v c memory start-rom-address running))))

; Running loop

(defn run-program
  ([program]
   (let [memory (get-empty-memory)
         [memory start-rom-address] (load-os memory default-os)
         memory (load-program memory program)
         state (make-state 0 0 (read-word memory 16rfff8) 0 0 0 0 0 0 0 memory start-rom-address true)]
     (loop [state state]
       (when (last state)
         (recur (von-neumann-machine-step state))))))
  ([program os]
   (let [memory (get-empty-memory)
         [memory start-rom-address] (load-os memory os)
         memory (load-program memory program)
         state (make-state 0 0 (read-word memory 16rfff8) 0 0 0 0 0 0 0 memory start-rom-address true)]
     (loop [state state]
       (when (last state)
         (recur (von-neumann-machine-step state)))))))
