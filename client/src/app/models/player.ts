import { Nationality } from './nationality'
import { Team } from './team'

export class Player {
  id!: number
  ime!: string
  prezime!: string
  brojReg!: string
  datumRodjenja!: Date
  nacionalnost!: Nationality
  tim!: Team
}
